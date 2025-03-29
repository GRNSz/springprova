package com.provaspring.springprova.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class Aluno {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @CPF(message = "CPF inválido.")
    @NotNull(message = "O CPF não pode ser nulo.")
    private String cpf;

    public Aluno() {
    }

    public Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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
}
