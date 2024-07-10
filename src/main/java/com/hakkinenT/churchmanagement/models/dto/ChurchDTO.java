package com.hakkinenT.churchmanagement.models.dto;

import com.hakkinenT.churchmanagement.models.entities.Church;

public class ChurchDTO {
    private String cnpj;
    private String name;
    private String email;
    private String motherChurchCnpj;

    public ChurchDTO() {
    }

    public ChurchDTO(String cnpj, String name, String email, String motherChurchCnpj) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.motherChurchCnpj = motherChurchCnpj;
    }

    public ChurchDTO(Church entity) {
        cnpj = entity.getCnpj();
        name = entity.getName();
        email = entity.getEmail();
        motherChurchCnpj = entity.getMotherChurch() == null ? null : entity.getMotherChurch().getCnpj();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotherChurchCnpj() {
        return motherChurchCnpj;
    }

    public void setMotherChurchCnpj(String motherChurchCnpj) {
        this.motherChurchCnpj = motherChurchCnpj;
    }
}
