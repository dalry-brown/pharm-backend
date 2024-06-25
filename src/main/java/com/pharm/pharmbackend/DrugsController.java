package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/drugs")
public class DrugsController {

    private final DrugServices drugService;

    @Autowired
    public DrugsController(DrugServices drugServices) {
        this.drugService = drugServices;
    }

    @PostMapping("/add")
    public Drugs addDrug(@RequestBody Drugs drug) {
        return drugService.addDrug(drug);
    }

//    @GetMapping("/search")
//    public ResponseEntity<Drugs> searchDrug(@RequestParam String name) {
//        return drugService.getDrugByName(name)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping(path = "{name}")
    public Optional<Drugs> getDrugByName(@PathVariable String name) {
        return drugService.getDrugByName(name);
    }

    @PutMapping(path = "{drugId}")
    public void updateDrug(
            @PathVariable("drugId") Long id,
            @RequestParam(required = false)String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) double quantity,
            @RequestParam(required = false) String description
    ){
        drugService.update(id, name, category, quantity, description);
    }

    @GetMapping("/all")
    public List<Drugs> getAllDrugs() {
        return drugService.getAllDrugs();
    }
}
