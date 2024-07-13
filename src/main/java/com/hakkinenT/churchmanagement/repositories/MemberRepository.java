package com.hakkinenT.churchmanagement.repositories;

import com.hakkinenT.churchmanagement.models.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
