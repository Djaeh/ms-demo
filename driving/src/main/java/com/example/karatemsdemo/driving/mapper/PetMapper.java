package com.example.karatemsdemo.driving.mapper;

import com.example.karatemsdemo.domain.model.Pet;
import com.example.karatemsdemo.domain.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {

    @Mapping(source = "id", target = "petId")
    @Mapping(source = "category.id", target = "category.categoryId")
    Pet toDomain(com.example.karatemsdemo.rest.model.Pet pet);

    @Mapping(source = "id", target = "tagId")
    Tag toDomain(com.example.karatemsdemo.rest.model.Tag tag);

    @Mapping(target = "id", source = "tagId")
    com.example.karatemsdemo.rest.model.Tag toRestModel(Tag tag);

    @Mapping(target = "id", source = "petId")
    @Mapping(target = "category.id", source = "category.categoryId")
    com.example.karatemsdemo.rest.model.Pet toRestModel(Pet pet);
}
