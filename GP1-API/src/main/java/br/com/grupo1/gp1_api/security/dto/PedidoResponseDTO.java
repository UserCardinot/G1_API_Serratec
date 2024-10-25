package br.com.grupo1.gp1_api.security.dto;

import java.time.LocalDate;

public class PedidoResponseDTO {

	private Integer idPedido;
	private String status;
	private CarrinhoResponseDTO carrinho;
	private LocalDate dataPedido;
	private Long nf;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CarrinhoResponseDTO getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoResponseDTO carrinho) {
		this.carrinho = carrinho;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Long getNf() {
		return nf;
	}

	public void setNf(Long nf) {
		this.nf = nf;
	}

}
