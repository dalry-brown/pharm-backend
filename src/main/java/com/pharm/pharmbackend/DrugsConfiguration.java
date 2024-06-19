package com.pharm.pharmbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class DrugsConfiguration {
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Drugs drug1 = new Drugs(

            );
        };
    }
}
