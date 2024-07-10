package com.hakkinenT.churchmanagement.models.dto;

import com.hakkinenT.churchmanagement.models.entities.Church;
import java.util.ArrayList;
import java.util.List;

public class ChurchMotherDTO {
    private String cnpj;
    private String name;
    private String email;
    private List<ChurchMinDTO> congregations = new ArrayList<>();

    public ChurchMotherDTO() {
    }

    public ChurchMotherDTO(String cnpj, String name, String email) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
    }

    public ChurchMotherDTO(Church entity) {
        cnpj = entity.getCnpj();
        name = entity.getName();
        email = entity.getEmail();
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

    public List<ChurchMinDTO> getCongregations() {
        return congregations;
    }

    public void setCongregations(List<ChurchMinDTO> congregations) {
        this.congregations = congregations;
    }
}
