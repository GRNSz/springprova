package com.provaspring.springprova.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class Aluno {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @CPF(message = "CPF inválido.")
    @NotNull(message = "O CPF não pode ser nulo.")
    private String cpf;

    @NotNull (message = "A idade não pode ser nula.")
    @Max(value = 150, message = "A idade não pode ser maior que 150 anos.")
    // @Min(value = 18, message = "A idade não pode ser menor que 18 anos.")
    private Integer idade;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int idade) {
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

    public  Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }
}
