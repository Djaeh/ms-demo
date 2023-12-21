package com.example.karatemsdemo.domain.spi;

import com.example.karatemsdemo.domain.model.Pet;

public interface SavePet {

    Pet save(Pet pet);
}
