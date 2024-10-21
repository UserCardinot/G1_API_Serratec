package br.com.grupo1.gp1_api.security.dto;

import br.com.grupo1.gp1_api.security.entities.Endereco;

public class EnderecoResponseDTO {
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public Endereco toEndereco() {
    	return new Endereco(this.id, this.cep, this.cidade, this.estado, 
    			this.numero, this.rua);
    }
}