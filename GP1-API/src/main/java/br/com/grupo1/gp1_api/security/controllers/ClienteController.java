package br.com.grupo1.gp1_api.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.ClienteDTO;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/{id}")
	public ClienteDTO pesquisarCliente(@PathVariable Integer id) {
		return clienteService.pesquisarCliente(id);
	}

	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.findAll();
	}
}
