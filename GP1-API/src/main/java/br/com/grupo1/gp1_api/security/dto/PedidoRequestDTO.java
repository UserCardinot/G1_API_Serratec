package br.com.grupo1.gp1_api.security.dto;


import java.time.LocalDate;

public class PedidoRequestDTO {
	
	private String status;
	
	private LocalDate dataPedido;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	
}
