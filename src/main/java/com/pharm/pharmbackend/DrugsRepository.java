package com.pharm.pharmbackend;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DrugsRepository extends JpaRepository<Drugs, Long> {
        Optional<Drugs> findByName(String name);
    }

