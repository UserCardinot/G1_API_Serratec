package br.com.grupo1.gp1_api.security.dto;

public class ProdutoDTO {

    private String nome;


    private String descricao;


    private Integer estoque;


    private Double preco;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Integer getEstoque() {
		return estoque;
	}


	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
    
}
