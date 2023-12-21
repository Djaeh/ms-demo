package com.example.karatemsdemo.domain.model;

import lombok.*;

import java.util.List;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pet {
    Long petId;

    String name;

    Category category;

    @Singular
    List<String> photoUrls;

    List<Tag> tags;
    Status status;
}
