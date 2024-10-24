package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.PedidoRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Carrinho;
import br.com.grupo1.gp1_api.security.entities.Pedido;
import br.com.grupo1.gp1_api.security.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private CarrinhoService carrinhoService;
    
    @Autowired 
    private ClienteService clienteService;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Integer obterIdClientePeloUsuario(String username) {
        return clienteService.buscarIdPorUsuario(username);
    }

    public Pedido criarPedido(PedidoRequestDTO pedidoRequest, Integer idCliente) {
    	
        Carrinho carrinhoDoCliente = carrinhoService.exibirCarrinhoByIdCliente(idCliente);

        Pedido novoPedido = new Pedido();
        novoPedido.setCarrinho(carrinhoDoCliente);
        novoPedido.setStatus(pedidoRequest.getStatus());

        return pedidoRepository.save(novoPedido);
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