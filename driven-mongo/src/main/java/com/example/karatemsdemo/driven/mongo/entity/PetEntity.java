package com.example.karatemsdemo.driven.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Value
@Document
@AllArgsConstructor
@Builder(toBuilder = true)
public class PetEntity {
    @Id
    String id;

    Long petId;

    String name;

    CategoryEntity category;

    List<String> photoUrls;

    List<TagEntity> tags;
    String status;

}
