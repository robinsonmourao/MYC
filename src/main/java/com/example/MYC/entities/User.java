package com.example.MYC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String numCadastro;

    public User() {
    }

    public User(Long id, String name, String numCadastro) {
        this.id = id;
        this.name = name;
        this.numCadastro = numCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumCadastro() {
        return numCadastro;
    }

    public void setNumCadastro(String numCadastro) {
        this.numCadastro = numCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(numCadastro, user.numCadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numCadastro);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numCadastro='" + numCadastro + '\'' +
                '}';
    }
}
