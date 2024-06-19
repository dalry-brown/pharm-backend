package com.pharm.pharmbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class DrugServices {

    private DrugsRepository drugRepository;

    @Autowired
    public DrugServices(DrugsRepository drugRepository){
        this.drugRepository = drugRepository;
    }
    private List<Drugs> drugList = new ArrayList<>();
    private Map<String, Drugs> drugMap = new HashMap<>();

    public Drugs addDrug(Drugs drug) {
        Drugs savedDrug = drugRepository.save(drug);
        drugList.add(savedDrug);
        drugMap.put(savedDrug.getName(), savedDrug);
        return savedDrug;
    }

    public Optional<Drugs> getDrugByName(String name) {
        return Optional.ofNullable(drugMap.get(name));
    }

    public List<Drugs> getAllDrugs() {
        return new ArrayList<>(drugList);
    }
}
