package com.example.karatemsdemo.driven.mongo.mapper;


import com.example.karatemsdemo.domain.model.Pet;
import com.example.karatemsdemo.driven.mongo.entity.PetEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMongoEntityMapper {

    PetEntity toEntity(Pet pet);

    Pet toDomain(PetEntity petEntity);
}
