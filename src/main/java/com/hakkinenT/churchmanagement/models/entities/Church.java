package com.hakkinenT.churchmanagement.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_church")
public class Church {
    @Id
    private String cnpj;
    private String name;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "mother_church_cnpj")
    private Church motherChurch;

    @OneToMany(mappedBy = "motherChurch")
    private List<Church> congregations = new ArrayList<>();

    @OneToMany(mappedBy = "church")
    private List<Person> people = new ArrayList<>();

    public Church() {
    }

    public Church(String cnpj, String name, String email, Church motherChurch) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.motherChurch = motherChurch;
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

    public Church getMotherChurch() {
        return motherChurch;
    }

    public void setMotherChurch(Church motherChurch) {
        this.motherChurch = motherChurch;
    }

    public List<Church> getCongregations() {
        return congregations;
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Church church = (Church) o;
        return Objects.equals(cnpj, church.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cnpj);
    }
}
