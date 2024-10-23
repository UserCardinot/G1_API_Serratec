package br.com.grupo1.gp1_api.security.dto;


import br.com.grupo1.gp1_api.security.entities.Carrinho;
import br.com.grupo1.gp1_api.security.entities.Cliente;

public class PedidoRequestDTO {
	
	private String status;
	private Carrinho carrinho;
	private Cliente cliente;
	private Long nf;
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Long getNf() {
		return nf;
	}
	public void setNf(Long nf) {
		this.nf = nf;
	}

}
