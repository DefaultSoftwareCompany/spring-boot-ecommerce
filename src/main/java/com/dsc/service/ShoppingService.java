package com.dsc.service;

import com.dsc.model.Purchase;
import com.dsc.repository.OfficeRepository;
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

    @Autowired
    public ShoppingService(PurchaseRepository purchaseRepository, UserRepository userRepository, OfficeRepository officeRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.officeRepository = officeRepository;
    }

    public Purchase save(Purchase purchase) {
        purchase.setCustomer(userRepository.getByUserName(purchase.getCustomer().getUserName()));
        purchase.setDateOfOrder(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        if (officeRepository.getByAddress_DistrictName(purchase.getAddress().getDistrictName()) == null) {
            purchase.setOffice(officeRepository.getAllByAddress_CityName(purchase.getAddress().getCityName()).get(0));
        } else {
            purchase.setOffice(officeRepository.getByAddress_DistrictName(purchase.getAddress().getDistrictName()));
        }
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllByCustomer(Long customerId){
        return purchaseRepository.getAllByCustomer_UserId(customerId);
    }


}
