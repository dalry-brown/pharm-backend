package com.pharm.pharmbackend;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Table
@Entity
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "drug_id")
    private Drugs drug;

    @Transient
    private LocalDateTime purchaseTime;

    private String buyer;

    private int quantity;

    public PurchaseHistory() {}

    public PurchaseHistory(Drugs drug, Long id, String buyer, int quantity) {
        this.drug = drug;
        this.id = id;
        this.buyer = buyer;
        this.quantity = quantity;
    }

    public PurchaseHistory(Drugs drug, String buyer, int quantity) {
        this.drug = drug;
        this.buyer = buyer;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drugs getDrug() {
        return drug;
    }

    public void setDrug(Drugs drug) {
        this.drug = drug;
    }

    public LocalDateTime getPurchaseTime() {
        return LocalDateTime.now();
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
