package br.com.grupo1.gp1_api.security.dto;

public class PedidoResponseDTO {

    private Integer idPedido;
    private String status;
    private Integer idCarrinho;
    private Integer idCliente;

    public PedidoResponseDTO(Integer idPedido, String status, Integer idCarrinho, Integer idCliente) {
        this.idPedido = idPedido;
        this.status = status;
        this.idCarrinho = idCarrinho;
        this.idCliente = idCliente;
    }

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

    public Integer getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Integer idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
