package com.dsc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private Float productPrice;

    private Long quantity;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                ", productImage=" + productImage +
                ", category=" + category +
                ", firm=" + firm +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                '}';
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Image productImage;

    @ManyToOne
    @JoinColumn
    private Category category;

    @ManyToOne
    @JoinColumn
    private Firm firm;

    private String dateOfManufacture;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Purchase> purchases;
}
