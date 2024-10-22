package br.com.grupo1.gp1_api.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.services.EmailService;

@RestController
@RequestMapping("/teste")
public class EmailController {

	@Autowired
	EmailService emailService;

	@GetMapping
	public String teste() {
		emailService.emailTeste();
		return "Email enviado com sucesso!";
	}
}
