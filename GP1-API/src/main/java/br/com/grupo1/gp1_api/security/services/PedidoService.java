package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.PedidoRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Pedido;
import br.com.grupo1.gp1_api.security.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

	public Pedido criarPedido(PedidoRequestDTO pedidoRequest){
		Pedido newPedido = new Pedido();
		newPedido.setCarrinho(pedidoRequest.getCarrinho());
		newPedido.setStatus(pedidoRequest.getStatus());
		return pedidoRepository.save(newPedido);	
	}
     
	public Pedido atualizarPedido(Integer id, String status) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		pedido.get().setStatus(status);
		return pedidoRepository.save(pedido.get());
	}

	public void deletarPedido(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		pedidoRepository.delete(pedido.get());
		
	}
}