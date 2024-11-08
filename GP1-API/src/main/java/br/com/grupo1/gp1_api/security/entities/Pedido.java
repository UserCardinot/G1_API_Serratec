package br.com.grupo1.gp1_api.security.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.grupo1.gp1_api.security.dto.CarrinhoResponseDTO;
import br.com.grupo1.gp1_api.security.dto.PedidoResponseDTO;
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
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_cd_id")
	private Integer id;

	@Column(name = "ped_dt_data_pedido")
	private LocalDate dataPedido;

	@Column(name = "ped_tx_status")
	private String status;

	@OneToOne
	@JoinColumn(name = "ped_fk_carrinho")
	@JsonManagedReference
	private Carrinho carrinho;

	@ManyToOne
	@JoinColumn(name = "ped_fk_cliente", nullable = false)
	@JsonManagedReference
	private Cliente cliente;

	@Column(name = "ped_tx_nf")
	private Long nf;

	public Pedido() {
	}

	public Pedido(LocalDate dataPedido, String status, Carrinho carrinho, Cliente cliente, Long nf) {
		this.dataPedido = dataPedido;
		this.status = status;
		this.carrinho = carrinho;
		this.cliente = cliente;
		this.nf = nf;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNf() {
		return nf;
	}

	public void setNf(Long nf) {
		this.nf = nf;
	}

	public Integer getId() {
		return id;
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

	public PedidoResponseDTO toPedidoResponseDTO() {

		PedidoResponseDTO pedidoResponse = new PedidoResponseDTO();

		CarrinhoResponseDTO carrinhoResponse = this.carrinho.toCarrinhoResponseDTO();

		pedidoResponse.setCarrinho(carrinhoResponse);
		pedidoResponse.setDataPedido(this.getDataPedido());
		pedidoResponse.setIdPedido(this.getId());
		pedidoResponse.setNf(this.getNf());
		pedidoResponse.setStatus(this.getStatus());

		return pedidoResponse;
	}
}