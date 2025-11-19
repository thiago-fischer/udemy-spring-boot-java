package com.fischer.thiago.v1.repository;

import com.fischer.thiago.v1.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
