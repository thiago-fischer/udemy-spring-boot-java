package com.fischer.thiago.repository;

import com.fischer.thiago.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
