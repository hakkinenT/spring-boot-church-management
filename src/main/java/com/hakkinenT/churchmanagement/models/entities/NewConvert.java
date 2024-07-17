package com.hakkinenT.churchmanagement.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_new_convert")
public class NewConvert extends Person{
    public NewConvert() {
    }

    public NewConvert(String cpf, String firstName, String lastName, LocalDate birthDate, String email, String maritalStatus, LocalDate conversionDate, Church church) {
        super(cpf, firstName, lastName, birthDate, email, maritalStatus, conversionDate, church);
    }
}
