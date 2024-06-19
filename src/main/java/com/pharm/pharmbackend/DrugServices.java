package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DrugServices {

    private final DrugsRepository drugRepository;

    @Autowired
    public DrugServices(DrugsRepository drugRepository){
        this.drugRepository = drugRepository;
    }
    private final List<Drugs> drugList = new ArrayList<>();
    private final Map<String, Drugs> drugMap = new HashMap<>();


    // adding drugs to the database
    public Drugs addDrug(Drugs drug) {
        Optional<Drugs> drugs = drugRepository.findByName(drug.getName());
        if (drugs.isPresent()) {
            throw new IllegalArgumentException("drugs already exists");
        }
        Drugs savedDrug = drugRepository.save(drug);
        drugList.add(savedDrug);
        drugMap.put(savedDrug.getName(), savedDrug);
        return savedDrug;
    }


    // getting drugs by the name
    public Optional<Drugs> getDrugByName(String name) {
        return Optional.ofNullable(drugMap.get(name));
    }


    // getting all the drugs
    public List<Drugs> getAllDrugs() {
        return new ArrayList<>(drugList);
    }


    // update all the drugs features
    public void update(Long id, String name, String category, double quantity, String description) {
        Drugs drugs = drugRepository.findById(id).orElseThrow(()->new IllegalStateException("Drugs not found") );
        if(name != null && !name.isEmpty()&& !Objects.equals(drugs.getName(), name)) {
            drugs.setName(name);
        }
        if(category != null && !category.isEmpty() && !Objects.equals(drugs.getCategory(), category)) {
            drugs.setCategory(category);
        }
        if(quantity != drugs.getQuantity() ){
            drugs.setQuantity(quantity);
        }
        if(description != null && !description.isEmpty() && !Objects.equals(drugs.getDescription(), description)) {
            drugs.setDescription(description);
        }

    }

}
