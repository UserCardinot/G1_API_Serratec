package br.com.grupo1.gp1_api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);

    Boolean existsByNome(String nome);

    Boolean existsByPreco(Double preco);

    Boolean existsByDescricao(String descricao);

    Boolean existsByEstoque(Integer estoque);
}