package com.hakkinenT.churchmanagement.models.dto;

import com.hakkinenT.churchmanagement.models.entities.Church;
import com.hakkinenT.churchmanagement.models.projections.ChurchProjection;

import java.util.Objects;

public class ChurchMinDTO {
    private String cnpj;
    private String name;
    private String email;


    public ChurchMinDTO() {
    }

    public ChurchMinDTO(String cnpj, String name, String email) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
    }

    public ChurchMinDTO(Church entity) {
        cnpj = entity.getCnpj();
        name = entity.getName();
        email = entity.getEmail();
    }

    public ChurchMinDTO(ChurchProjection projection) {
        cnpj = projection.getCnpj();
        name = projection.getName();
        email = projection.getEmail();
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
}
