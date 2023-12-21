package com.example.karatemsdemo.domain.pet.service;

import com.example.karatemsdemo.domain.model.Pet;
import com.example.karatemsdemo.domain.pet.api.AddPet;
import com.example.karatemsdemo.domain.pet.validator.PetValidator;
import com.example.karatemsdemo.domain.spi.SavePet;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddPetService implements AddPet {

    SavePet savePet;
    @Override
    public Pet apply(Pet pet) {
        return Try.of(() -> pet)
                .andThen(PetValidator::isValid)
                .mapTry(savePet::save)
                .get();
    }
}
