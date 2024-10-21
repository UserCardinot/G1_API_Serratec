package br.com.grupo1.gp1_api.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_cd_id")
    private Integer id;

    @Column(name = "cl_nome")
    private String nomeCliente;

    @Column(name = "cl_cpf")
    private Double cpf;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "end_int_id")
    private Endereco endereco;

    
  
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	
}