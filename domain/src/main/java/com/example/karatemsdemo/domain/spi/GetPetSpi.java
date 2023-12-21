package com.example.karatemsdemo.domain.spi;

import com.example.karatemsdemo.domain.model.Pet;

public interface GetPetSpi {

    Pet getPetById(Long id);
}
