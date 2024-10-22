package br.com.grupo1.gp1_api.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}