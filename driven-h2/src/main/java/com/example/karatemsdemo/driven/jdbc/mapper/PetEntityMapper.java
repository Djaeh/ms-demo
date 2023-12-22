package com.example.karatemsdemo.driven.jdbc.mapper;

import com.example.karatemsdemo.domain.model.Pet;
import com.example.karatemsdemo.driven.jdbc.entity.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetEntityMapper {

    PetEntity toEntity(Pet pet);

    Pet toDomain(PetEntity petEntity);
}
