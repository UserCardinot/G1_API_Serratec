package br.com.grupo1.gp1_api.security.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.CarrinhoRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Carrinho;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.Produto;
import br.com.grupo1.gp1_api.security.repositories.CarrinhoRepository;
import br.com.grupo1.gp1_api.security.repositories.ClienteRepository;
import br.com.grupo1.gp1_api.security.repositories.ProdutoRepository;

@Service
public class CarrinhoService {

	@Autowired
	CarrinhoRepository carrinhoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public Carrinho exibirCarrinhoByIdCliente(int idCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		if (!cliente.isPresent()) {
			return null;
		}

		Optional<Carrinho> carrinho = carrinhoRepository.findByCliente(cliente.get());

		if (!carrinho.isPresent()) {
			return null;
		}

		return carrinho.get();
	}

	public Carrinho cadastrarCarrinho(CarrinhoRequestDTO carrinhoRequest) {
		Optional<Cliente> cliente = clienteRepository.findById(carrinhoRequest.getIdCliente());

		if (!cliente.isPresent()) {
			return null;
		}

		Optional<Produto> produto = produtoRepository.findById(carrinhoRequest.getIdProduto());
		
		if (!produto.isPresent()) {
			return null;
		}
		
		Optional<Carrinho> carrinho = carrinhoRepository.findByCliente(cliente.get());

		if (carrinho.isPresent()) {
			Set<Produto> listaProdutos = carrinho.get().getProdutos();
			listaProdutos.add(produto.get());
			carrinho.get().setProdutos(listaProdutos);
			return carrinhoRepository.save(carrinho.get());
		}

		Set<Produto> novaListaProdutos = new HashSet<>();
		novaListaProdutos.add(produto.get());
		
		Carrinho novoCarrinho = new Carrinho();
		novoCarrinho.setCliente(cliente.get());
		novoCarrinho.setProdutos(novaListaProdutos);
		
		return carrinhoRepository.save(novoCarrinho);

	}
}
