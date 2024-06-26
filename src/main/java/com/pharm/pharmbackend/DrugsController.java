package com.pharm.pharmbackend;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drugs")
@CrossOrigin(origins = "http://192.168.8.101:5173/")
public class DrugsController {

    private final DrugServices drugServices;

    @Autowired
    public DrugsController(DrugServices drugServices){
        this.drugServices = drugServices;
    }

    @GetMapping
    public List<Drugs> getAllDrugs(){
        return drugServices.getAllDrugs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drugs> getDrugById(@PathVariable Integer id){
        return drugServices.getDrugById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Drugs addDrug(@RequestBody Drugs drugs){
        return drugServices.addDrug(drugs);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Drugs> updateDrug(@PathVariable Integer id, @RequestBody Drugs updatedDrugs){
        return drugServices.updateDrug(id, updatedDrugs)
                .map(updateDrug -> ResponseEntity.ok().body(updateDrug))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable Integer id) {
        try {
            drugServices.deleteDrug(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
