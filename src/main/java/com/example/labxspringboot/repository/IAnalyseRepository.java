package com.example.labxspringboot.repository;

import com.example.labxspringboot.entity.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAnalyseRepository extends JpaRepository<Analyse , Long> {
    Optional<Analyse> findByIdAndDeletedFalse(Long id);
}
