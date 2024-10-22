package br.com.grupo1.gp1_api.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.entities.Funcionario;
import br.com.grupo1.gp1_api.security.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{nome}")
    public Funcionario getFuncionarioByNome(String nome) {
        return funcionarioRepository.findByNome(nome).get();
    }
}