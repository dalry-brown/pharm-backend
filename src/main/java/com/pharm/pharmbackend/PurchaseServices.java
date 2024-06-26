package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServices {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServices(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAllPurchases(){
        return purchaseRepository.findAll();
    }

    public Optional<Purchase> getPurchaseId(Integer id){
        return purchaseRepository.findById(id);
    }

    public  Purchase addPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public Optional<Purchase> updatePurchase(Integer id, Purchase updatedPurchase){
        return purchaseRepository.findById(id).map(purchase -> {
            purchase.setPurchaseId(updatedPurchase.getBuyerId());
            purchase.setDrug(updatedPurchase.getDrug());
            purchase.setQuantity(updatedPurchase.getQuantity());
            purchase.setDate(updatedPurchase.getDate());
            purchase.setTime(updatedPurchase.getTime());
            return purchaseRepository.save(purchase);
        });
    }

    public void deletePurchase(Integer id){
        if(purchaseRepository.existsById(id)){
            purchaseRepository.deleteById(id);
        }else {
            throw new IllegalArgumentException("Purchase with ID " + id + " not found.");
        }
    }

}
