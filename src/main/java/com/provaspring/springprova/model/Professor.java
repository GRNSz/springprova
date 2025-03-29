package com.provaspring.springprova.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class Professor {

    @NotBlank (message = "O nome não pode estar em branco.")
    private String nome;

    @CPF(message = "CPF Invalido.")
    @NotBlank
    private String cpf;

    @NotBlank
    private String materia;

    public Professor(){
    }

    public Professor(String nome, String cpf, String materia) {
        this.nome = nome;
        this.cpf = cpf;
        this.materia = materia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
