package com.dsc.service;

import com.dsc.model.Address;
import com.dsc.model.Purchase;
import com.dsc.repository.OfficeRepository;
import com.dsc.repository.ProductRepository;
import com.dsc.repository.PurchaseRepository;
import com.dsc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingService {
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final OfficeRepository officeRepository;
    private final AddressService addressService;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingService(PurchaseRepository purchaseRepository, UserRepository userRepository, OfficeRepository officeRepository, AddressService addressService, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.officeRepository = officeRepository;
        this.addressService = addressService;
        this.productRepository = productRepository;
    }

    public Purchase save(Purchase purchase) throws Exception {
        purchase.setCustomer(userRepository.getByUserName(purchase.getCustomer().getUserName()));
        purchase.setDateOfOrder(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        if (purchase.getAddress() != null) {
            purchase.setAddress(addressService.save(purchase.getAddress()));
        }
        if (officeRepository.getByAddress_DistrictName(purchase.getAddress().getDistrictName()) == null) {
            purchase.setOffice(officeRepository.getAllByAddress_CityName(purchase.getAddress().getCityName()).get(0));
        } else {
            purchase.setOffice(officeRepository.getByAddress_DistrictName(purchase.getAddress().getDistrictName()));
        }
        purchase.setDeadline((byte) 20);
        purchase.setCompletion(false);
        purchase.setProduct(productRepository.findById(purchase.getProduct().getProductId()).get());
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllByCustomer(Long customerId) {
        return purchaseRepository.getAllByCustomer_UserId(customerId);
    }


    public void confirm(Long purchaseId) {
        Address address = purchaseRepository.findById(purchaseId).get().getAddress();
        purchaseRepository.deleteById(purchaseId);
        addressService.delete(address.getAddressId());
    }
}
