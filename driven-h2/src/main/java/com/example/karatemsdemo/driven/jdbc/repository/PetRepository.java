package com.example.karatemsdemo.driven.jdbc.repository;

import com.example.karatemsdemo.driven.jdbc.entity.PetEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("h2")
public interface PetRepository extends JpaRepository<PetEntity, Long> {


    Optional<PetEntity> findByPetId(Long aLong);
}
