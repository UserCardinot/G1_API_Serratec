package br.com.grupo1.gp1_api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Optional<Categoria> findByDescricao(String descricao);
}
