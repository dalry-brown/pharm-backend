package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/drugs/purchase-history")
public class PurchaseHistoryController {
    @Autowired
    private PurchaseHistoryService purchaseHistoryService;

    @GetMapping("/drug/{drugId}")
    public List<PurchaseHistory> getPurchaseHistoryByDrugId(@PathVariable Long drugId) {
        return purchaseHistoryService.getPurchaseHistoryByDrugId(drugId);
    }
}
