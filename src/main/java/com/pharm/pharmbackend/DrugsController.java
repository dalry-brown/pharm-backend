package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/drugs")
public class DrugsController {

    private DrugServices drugService;

    @Autowired
    public DrugsController(DrugServices drugServices) {
        this.drugService = drugServices;
    }

    @PostMapping("/add")
    public Drugs addDrug(@RequestBody Drugs drug) {
        return drugService.addDrug(drug);
    }

    @GetMapping("/search")
    public ResponseEntity<Drugs> searchDrug(@RequestParam String name) {
        return drugService.getDrugByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public List<Drugs> getAllDrugs() {
        return drugService.getAllDrugs();
    }
}
