package br.com.grupo1.gp1_api.security.dto;

import java.util.HashSet;
import java.util.Set;

public class CarrinhoResponseDTO {
	private int idCliente;
	private String NomeCliente;
	private Set<ProdutoDTO> produtos = new HashSet<>();
	private double valorTotal;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return NomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		NomeCliente = nomeCliente;
	}
	public Set<ProdutoDTO> getProdutos() {
		return produtos;
	}
	public void setProdutos(Set<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
