package br.com.grupo1.gp1_api.security.controllers;

import java.io.IOException;

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
		try {
			emailService.emailPersonalizadoPedido();
		} catch (IOException e) {
			e.printStackTrace();
			return "Falha ao enviar o email!";
		}
		return "Email enviado com sucesso!";
	}
}
