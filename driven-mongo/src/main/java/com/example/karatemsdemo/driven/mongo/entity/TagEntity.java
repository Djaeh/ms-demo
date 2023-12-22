package com.example.karatemsdemo.driven.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder(toBuilder = true)
public class TagEntity {
    Long tagId;
    String name;
}
