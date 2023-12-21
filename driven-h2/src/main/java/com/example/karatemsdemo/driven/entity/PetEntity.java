package com.example.karatemsdemo.driven.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Value
@Entity
@Table(name = "pet")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Builder(toBuilder = true)
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn
    Long id;

    Long petId;

    String name;

    @ManyToOne(cascade = CascadeType.ALL)
    CategoryEntity category;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "photos", joinColumns = @JoinColumn(name = "petId"))
    @Column(name = "url", nullable = false)
    List<String> photoUrls;

    @ManyToMany(cascade = CascadeType.ALL)
    List<TagEntity> tags;
    String status;

}
