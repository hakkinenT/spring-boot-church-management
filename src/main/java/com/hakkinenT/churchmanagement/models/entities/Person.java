package com.hakkinenT.churchmanagement.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_person")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    private String cpf;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Column(unique = true)
    private String email;
    private String maritalStatus;
    private LocalDate conversionDate;

    @ManyToOne
    @JoinColumn(name = "church_cnpj")
    private Church church;

    public Person() {
    }

    public Person(String cpf, String firstName, String lastName, LocalDate birthDate, String email, String maritalStatus, LocalDate conversionDate, Church church) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.conversionDate = conversionDate;
        this.church = church;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDate getConversionDate() {
        return conversionDate;
    }

    public void setConversionDate(LocalDate conversionDate) {
        this.conversionDate = conversionDate;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cpf, person.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

}
