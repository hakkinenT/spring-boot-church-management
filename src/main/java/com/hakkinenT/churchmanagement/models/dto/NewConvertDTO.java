package com.hakkinenT.churchmanagement.models.dto;

import com.hakkinenT.churchmanagement.models.entities.NewConvert;

import java.time.LocalDate;

public class NewConvertDTO {
    private String cpf;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String maritalStatus;
    private LocalDate conversionDate;

    public NewConvertDTO() {
    }

    public NewConvertDTO(String cpf, String firstName, String lastName, LocalDate birthDate, String email, String maritalStatus, LocalDate conversionDate) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.conversionDate = conversionDate;
    }

    public NewConvertDTO(NewConvert entity) {
        this.cpf = entity.getCpf();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.birthDate = entity.getBirthDate();
        this.email = entity.getEmail();
        this.maritalStatus = entity.getMaritalStatus();
        this.conversionDate = entity.getConversionDate();
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
}
