package br.com.grupo1.gp1_api.security.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cl_cd_id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "cl_fk_usuario")
	@JsonManagedReference
	private User user;

	@Column(name = "cl_nome")
	private String nome;

	@Column(name = "cl_cpf")
	private Double cpf;

	@ManyToOne
	@JoinColumn(name = "cl_fk_endereco")
	@JsonManagedReference
	private Endereco endereco;

	public Cliente() {
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Double getCpf() {
		return cpf;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public User getUser() {
		return user;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUser(User user) {
		this.user = user;
	}
}