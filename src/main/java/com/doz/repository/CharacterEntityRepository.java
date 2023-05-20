package com.doz.repository;

import com.doz.model.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {
    List<Optional<CharacterEntity>> findAllByName(String name);
}
