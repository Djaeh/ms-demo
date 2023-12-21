package com.example.karatemsdemo.domain.pet.api;

import com.example.karatemsdemo.domain.model.Pet;

public interface GetPet {
    Pet getById(Long id);
}
