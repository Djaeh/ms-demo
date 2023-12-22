package com.example.karatemsdemo.driven.jdbc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long categoryId;
    String name;

    @OneToMany
    List<PetEntity> pets;
}
