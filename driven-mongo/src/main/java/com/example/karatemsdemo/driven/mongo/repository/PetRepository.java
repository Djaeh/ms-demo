package com.example.karatemsdemo.driven.mongo.repository;

import com.example.karatemsdemo.driven.mongo.entity.PetEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("mongo")
public interface PetRepository extends MongoRepository<PetEntity, Long> {
    Optional<PetEntity> findByPetId(Long id);
}
