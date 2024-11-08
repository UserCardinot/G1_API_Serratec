package br.com.grupo1.gp1_api.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.entities.Role;
import br.com.grupo1.gp1_api.security.services.RoleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Role role) {

		Role newRole = roleService.save(role);

		if (newRole != null)
			return new ResponseEntity<>(newRole, HttpStatus.CREATED);
		else
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Role já cadastrada!");
	}

}