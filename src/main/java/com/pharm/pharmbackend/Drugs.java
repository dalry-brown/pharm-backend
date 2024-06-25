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
    private String category;
    private Double quantity;
    private String description;

    public Drugs(Long id, String name, String category, Double quantity, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
    }

    public Drugs(String name, String category, double quantity, String description) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
    }

    public Drugs() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
