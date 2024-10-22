package br.com.grupo1.gp1_api.security.entities;

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
	private User user;

	@Column(name = "cl_nome")
	private String nomeCliente;

	@Column(name = "cl_cpf")
	private Double cpf;

	@ManyToOne
	@JoinColumn(name = "cl_fk_endereco")
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

	public String getNomeCliente() {
		return nomeCliente;
	}

}