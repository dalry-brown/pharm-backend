package com.pharm.pharmbackend;

import jakarta.persistence.*;

@Entity
@Table
public class Drugs {
    @Id
    @SequenceGenerator(
            name = "drug_sequence",
            sequenceName = "drug_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "drug_sequence"
    )
    private Long id;

    private String name;
    private String supplier;
    private double price;

    public Drugs(Long id, String name, String supplier, double price) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }

    public Drugs(String name, String supplier, double price) {
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }
    public Drugs() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
