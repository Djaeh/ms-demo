package com.example.karatemsdemo.driven.adapter;

import com.example.karatemsdemo.domain.model.Pet;
import com.example.karatemsdemo.domain.spi.GetPetSpi;
import com.example.karatemsdemo.domain.spi.SavePet;
import com.example.karatemsdemo.driven.mapper.PetEntityMapper;
import com.example.karatemsdemo.driven.repository.PetRepository;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("h2")
@Component
@AllArgsConstructor
public class PetAdapter implements SavePet, GetPetSpi {

    PetRepository petRepository;
    PetEntityMapper petEntityMapper;
    @Override
    public Pet save(Pet pet) {
        return Try.of(() -> petEntityMapper.toEntity(pet))
                .mapTry(petRepository::save)
                .mapTry(petEntityMapper::toDomain)
                .get();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findByPetId(id)
                .map(petEntityMapper::toDomain)
                .orElse(null);
    }
}
