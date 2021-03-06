package com.dsc.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne
    @JoinColumn
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User customer;

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", product=" + product +
                ", customer=" + customer +
                ", orderQuantity=" + orderQuantity +
                ", office=" + office +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                ", deadline=" + deadline +
                ", completion=" + completion +
                ", address=" + address +
                '}';
    }

    private Integer orderQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private DeliveryOffice office;

    private String dateOfOrder;

    @Column(columnDefinition = "smallint default 20")
    private byte deadline;

    @Column(columnDefinition = "boolean default false")
    private Boolean completion;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Address address;
}
