package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseHistoryService {
    @Autowired
    private PurchaseHistoryRepository purchaseHistoryRepository;

    public List<PurchaseHistory> getPurchaseHistoryByDrugId(Long drugId) {
        return purchaseHistoryRepository.findByDrugId(drugId);
    }

    public PurchaseHistory addPurchaseHistory(PurchaseHistory purchaseHistory) {
        return purchaseHistoryRepository.save(purchaseHistory);
    }
}
