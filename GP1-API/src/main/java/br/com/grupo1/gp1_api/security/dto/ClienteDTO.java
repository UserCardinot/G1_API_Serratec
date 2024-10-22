package br.com.grupo1.gp1_api.security.dto;

import br.com.grupo1.gp1_api.security.entities.User;


public class ClienteDTO {
	
	private Integer id;

	private User user;

	private String nome;

	private Double cpf;

	public User getUser() {
		return user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}
	
}

