package br.com.grupo1.gp1_api.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.EnderecoRequestDTO;
import br.com.grupo1.gp1_api.security.dto.EnderecoResponseDTO;
import br.com.grupo1.gp1_api.security.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	

	@PostMapping
	public ResponseEntity<EnderecoResponseDTO> criarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
		EnderecoResponseDTO response = enderecoService.salvarEndereco(enderecoRequestDTO);
		System.out.println("controller: " + response);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}