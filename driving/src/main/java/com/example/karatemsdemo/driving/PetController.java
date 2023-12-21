package com.example.karatemsdemo.driving;

import com.example.karatemsdemo.domain.pet.api.AddPet;
import com.example.karatemsdemo.domain.pet.api.GetPet;
import com.example.karatemsdemo.driving.mapper.PetMapper;
import com.example.karatemsdemo.rest.PetApi;
import com.example.karatemsdemo.rest.model.Pet;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PetController implements PetApi {

    AddPet addPet;
    GetPet getPet;
    PetMapper petMapper;

    @Override
    public ResponseEntity<Pet> addPet(Pet pet) {
        return Try.of(() -> petMapper.toDomain(pet))
                .mapTry(addPet::apply)
                .mapTry(petMapper::toRestModel)
                .mapTry(this::toRestEntity)
                .get();
    }

    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return Try.of(() -> petId)
                .mapTry(getPet::getById)
                .mapTry(petMapper::toRestModel)
                .mapTry(this::toRestEntity)
                .get();
    }

    ResponseEntity<Pet> toRestEntity(Pet pet) {
        return ResponseEntity.ofNullable(pet);
    }
}
