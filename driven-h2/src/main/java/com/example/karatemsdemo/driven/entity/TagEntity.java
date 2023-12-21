package com.example.karatemsdemo.driven.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long tagId;
    String name;
}
