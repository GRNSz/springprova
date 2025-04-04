package com.provaspring.springprova.services;

import com.provaspring.springprova.model.Aluno;
import com.provaspring.springprova.model.Pessoa;
import com.provaspring.springprova.model.Professor;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
    @RequestMapping("/api/v1/")
    public class PessoaRestController {

    @Autowired
    private Validator validator;

    private final List<Aluno> alunos = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();

    @GetMapping("/alunos")
    public List<Aluno> getAlunos() {
        return alunos;
    }

    @PostMapping("/inseriraluno")
    public Aluno inserirAluno(@Valid @RequestBody Aluno aluno) {
        Set<ConstraintViolation<Aluno>> validate = validator.validate(aluno);
        if (!validate.isEmpty()) {
            throw new IllegalArgumentException("Erro ao inserir aluno: " + validate);
        }
        alunos.add(aluno);
        System.out.println("O aluno adicionado foi: " + aluno);
        return aluno;
    }
    @GetMapping("/professores")
    public List<Professor> getProfessores () {
        return professores;
    }

    @PostMapping("/inserirprof")
    public Professor inserirProfessor(@Valid @RequestBody Professor professor) {
        Set<ConstraintViolation<Professor>> validate = validator.validate(professor);
        if (!validate.isEmpty()) {
            throw new IllegalArgumentException("Erro ao inserir professor: " + validate);
        }
        professores.add(professor); 
        System.out.println("O professor adicionado foi: " + professor);
        return professor;
    }

    // Apenas atualiza o aluno se ele for maior de 18 anos.
    @PutMapping("/atualizaraluno/{index}")
    public Aluno atualizarAluno(@PathVariable int index, @Valid @RequestBody Aluno aluno){
        if (index < 0 || index >= alunos.size()) {
            throw new IllegalArgumentException("Índice inválido: " + index);
        }
        if (aluno.getIdade() < 18) {
            throw new IllegalArgumentException("O aluno deve ser maior de 18 anos para ser atualizado.");
        }
    }


    @GetMapping("/error404")
    public String error() {
        return "404 - Not Found";
    }
}