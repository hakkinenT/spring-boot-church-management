package com.hakkinenT.churchmanagement.repositories;

import com.hakkinenT.churchmanagement.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
