package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.PedidoRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Carrinho;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.Pedido;
import br.com.grupo1.gp1_api.security.entities.User;
import br.com.grupo1.gp1_api.security.repositories.CarrinhoRepository;
import br.com.grupo1.gp1_api.security.repositories.ClienteRepository;
import br.com.grupo1.gp1_api.security.repositories.PedidoRepository;
import br.com.grupo1.gp1_api.security.repositories.UserRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Autowired
	UserRepository userRepository;

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public Integer obterIdClientePeloUsuario(String username) {
		Optional<User> usuario = userRepository.findByUsername(username);
		Cliente cliente = clienteRepository.findByUser(usuario.get()).get(0);
		return cliente.getId();
	}

	public Pedido criarPedido(PedidoRequestDTO pedidoRequest, Integer idCliente) {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Optional<Carrinho> carrinho = carrinhoRepository.findByCliente(cliente.get());
		Pedido novoPedido = new Pedido();
		novoPedido.setCarrinho(carrinho.get());
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