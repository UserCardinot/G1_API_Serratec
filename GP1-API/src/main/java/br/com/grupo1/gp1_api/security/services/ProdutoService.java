package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.ProdutoDTO;
import br.com.grupo1.gp1_api.security.entities.Produto;
import br.com.grupo1.gp1_api.security.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findByNome(String nome) {
		return produtoRepository.findByNome(nome).get();
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public ProdutoDTO getProdutoById(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		ProdutoDTO produtoDto = new ProdutoDTO();
		produtoDto.setDescricao(produto.get().getDescricao());
		produtoDto.setEstoque(produto.get().getEstoque());
		produtoDto.setNome(produto.get().getNome());
		produtoDto.setPreco(produto.get().getPreco());

		return produtoDto;
	}

	public void deletarProduto(Integer id) {
		produtoRepository.deleteById(id);
	}

	public Produto atualizarProduto(Integer id, ProdutoDTO produtoDto) {
		Optional<Produto> produtoUpdate = produtoRepository.findById(id);

		if (produtoUpdate.isPresent()) {
			Produto produto = produtoUpdate.get();
			produto.setNome(produtoDto.getNome());
			produto.setDescricao(produtoDto.getDescricao());
			produto.setEstoque(produtoDto.getEstoque());
			return produtoRepository.save(produto);
		} else {
			throw new RuntimeException("ID não encontrado");
		}
	}

	public Produto criarProduto(ProdutoDTO produtoDto) {
		Produto newProduto = new Produto();
		newProduto.setNome(produtoDto.getNome());
		newProduto.setDescricao(produtoDto.getDescricao());
		newProduto.setEstoque(produtoDto.getEstoque());
		newProduto.setPreco(produtoDto.getPreco());
		return produtoRepository.save(newProduto);
	}
}
