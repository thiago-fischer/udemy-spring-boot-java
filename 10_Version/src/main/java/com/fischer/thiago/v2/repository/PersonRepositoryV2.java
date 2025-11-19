package com.fischer.thiago.v2.repository;

import com.fischer.thiago.v2.models.PersonV2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryV2 extends JpaRepository<PersonV2, Long> {
}
