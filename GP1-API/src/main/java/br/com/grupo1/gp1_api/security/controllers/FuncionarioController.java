package br.com.grupo1.gp1_api.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.FuncionarioRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Funcionario;
import br.com.grupo1.gp1_api.security.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;

	@GetMapping
	public List<Funcionario> getAllFuncionarios() {
		return funcionarioService.findAll();
	}

	@GetMapping("/{nome}")
	public Funcionario getFuncionarioByNome(String nome) {
		return funcionarioService.findByNome(nome);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarFuncionario(@PathVariable int id,
			@RequestBody FuncionarioRequestDTO funcionarioRequest) {
		Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionarioRequest);

		if (funcionarioAtualizado == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Erro ao atualizar o funcionário! Verifique as informações e tente novamente.");
		}

		return ResponseEntity.ok(funcionarioAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarFuncionario(@PathVariable int id) {
		if (funcionarioService.deletarFuncionario(id)) {
			return ResponseEntity.ok().body("Usuário deletado com sucesso!");
		} else {
			return ResponseEntity.badRequest().body("Erro: Não foi possível encontrar o funcionário de id " + id);
		}
	}
}