package com.example.karatemsdemo.domain.pet.service;

import com.example.karatemsdemo.domain.model.Pet;
import com.example.karatemsdemo.domain.pet.api.GetPet;
import com.example.karatemsdemo.domain.spi.GetPetSpi;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetPetService implements GetPet {

    GetPetSpi getPetSpi;
    @Override
    public Pet getById(Long id) {
        return getPetSpi.getPetById(id);
    }
}
