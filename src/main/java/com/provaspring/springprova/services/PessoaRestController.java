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
    Validator validator;

    @GetMapping("/alunos")
    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Jorge", "51198256800"));
        alunos.add(new Aluno("Marco", "67829102938"));
        alunos.add(new Aluno("Erick", "19203001284"));
        alunos.add(new Aluno("Leticia", "78201893012"));
        return alunos;
    }

    @PostMapping("/inseriraluno")
    public Aluno inserirAluno(@Valid @RequestBody Aluno aluno) {
        Set<ConstraintViolation<Aluno>> validate = validator.validate(aluno);
        if (!validate.isEmpty()) {
            throw new IllegalArgumentException("Erro ao inserir aluno: " + validate);
        }
        System.out.println("O aluno adicionado foi: " + aluno);
        return aluno;
    }
        @GetMapping("/professores")
        public List<Professor> getProfessores () {
            List<Professor> professores = new ArrayList<>();
            professores.add(new Professor("Wagner", "29091095857", "DS2"));
            professores.add(new Professor("Rebeca", "15502050211", "PW3"));
            professores.add(new Professor("Edinei", "29091095857", "IP"));
            return professores;
        }

    @PostMapping("/inserirprof")
    public Professor inserirProfessor(@Valid @RequestBody Professor professor) {
        Set<ConstraintViolation<Professor>> validate = validator.validate(professor);
        if (!validate.isEmpty()) {
            throw new IllegalArgumentException("Erro ao inserir professor: " + validate);
        }
        System.out.println("O professor adicionado foi: " + professor);
        return professor;
    }
}