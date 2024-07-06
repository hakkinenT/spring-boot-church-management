package com.hakkinenT.churchmanagement.repositories;

import com.hakkinenT.churchmanagement.models.entities.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church, String> {
}
