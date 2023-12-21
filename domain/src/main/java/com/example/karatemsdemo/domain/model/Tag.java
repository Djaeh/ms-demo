package com.example.karatemsdemo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tag {
    Long tagId;
    String name;
}
