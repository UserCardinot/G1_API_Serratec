package br.com.grupo1.gp1_api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fun_cd_id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "fun_fk_usuario")
	private User user;

	@Column(name = "fun_txt_nome")
	private String nome;

	@Column(name = "fun_int_salario")
	private Double salario;

	@Column(name = "fun_txt_cargo")
	private String cargo;

	@Column(name = "fun_txt_telefone")
	private String telefone;

	public Funcionario() {
	}

	public Funcionario(String nome, Double salario, String cargo, String telefone) {
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getSalario() {
		return salario;
	}

	public String getCargo() {
		return cargo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}