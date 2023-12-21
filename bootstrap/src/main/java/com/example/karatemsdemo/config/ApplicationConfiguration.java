package com.example.karatemsdemo.config;

import com.example.karatemsdemo.domain.pet.api.AddPet;
import com.example.karatemsdemo.domain.pet.api.GetPet;
import com.example.karatemsdemo.domain.pet.service.AddPetService;
import com.example.karatemsdemo.domain.pet.service.GetPetService;
import com.example.karatemsdemo.domain.spi.GetPetSpi;
import com.example.karatemsdemo.domain.spi.SavePet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfiguration {

    @Bean
    AddPet addPetService(SavePet savePet) {
        return new AddPetService(savePet);
    }

    @Bean
    GetPet getPetService(GetPetSpi getPet) {
        return new GetPetService(getPet);
    }
}