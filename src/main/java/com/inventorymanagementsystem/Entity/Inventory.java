package com.inventorymanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventory")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "vendor_name")
    private String vendorName;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "status")
    private String status;

    public Inventory() {
    }

    public Inventory(String productName, String vendorName, double price, Long quantity, String status) {
        this.productName = productName;
        this.vendorName = vendorName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }
}
