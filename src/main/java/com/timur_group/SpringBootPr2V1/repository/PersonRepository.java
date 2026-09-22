package com.timur_group.SpringBootPr2V1.repository;

import com.timur_group.SpringBootPr2V1.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
