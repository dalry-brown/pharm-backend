package com.pharm.pharmbackend;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drugs drug;

    private LocalDateTime purchaseTime;

    private String buyer;

    private int quantity;

    public PurchaseHistory() {}

    public PurchaseHistory(Drugs drug, Long id, LocalDateTime purchaseTime, String buyer, int quantity) {
        this.drug = drug;
        this.id = id;
        this.purchaseTime = purchaseTime;
        this.buyer = buyer;
        this.quantity = quantity;
    }

    public PurchaseHistory(Drugs drug, LocalDateTime purchaseTime, String buyer, int quantity) {
        this.drug = drug;
        this.purchaseTime = purchaseTime;
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
        return purchaseTime;
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
