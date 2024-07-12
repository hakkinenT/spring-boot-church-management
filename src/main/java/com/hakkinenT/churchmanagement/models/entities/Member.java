package com.hakkinenT.churchmanagement.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_member")
public class Member extends Person{
    private LocalDate baptismDate;

    public Member() {
    }

    public Member(String cpf, String firstName, String lastName, LocalDate birthDate, String email, String maritalStatus, LocalDate conversionDate, LocalDate baptismDate) {
        super(cpf, firstName, lastName, birthDate, email, maritalStatus, conversionDate);
        this.baptismDate = baptismDate;
    }

    public LocalDate getBaptismDate() {
        return baptismDate;
    }

    public void setBaptismDate(LocalDate baptismDate) {
        this.baptismDate = baptismDate;
    }
}
