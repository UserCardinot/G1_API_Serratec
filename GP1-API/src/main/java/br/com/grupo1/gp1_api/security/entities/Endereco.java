package br.com.grupo1.gp1_api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "end_cd_id")
	private Integer id;

	@Column(name = "end_tx_logradouro")
	private String logradouro;

	@Column(name = "end_int_numero")
	private int numero;

	@Column(name = "end_tx_localidade")
	private String localidade;

	@Column(name = "end_tx_uf")
	private String uf;

	@Column(name = "end_tx_cep")
	private String cep;

	@Column(name = "end_tx_complemento")
	private String complemento;

	@Column(name = "end_tx_bairro")
	private String bairro;

	public Endereco() {

	}

	public Endereco(String logradouro, int numero, String localidade, String uf, String cep, String complemento,
			String bairro) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", localidade=" + localidade
				+ ", uf=" + uf + ", cep=" + cep + ", complemento=" + complemento + ", bairro=" + bairro + "]";
	}

}