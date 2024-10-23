package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.entities.Categoria;
import br.com.grupo1.gp1_api.security.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria cadastrarCategoria(String descricao) {
		Categoria novaCategoria = new Categoria(descricao.trim().toLowerCase());
		return categoriaRepository.save(novaCategoria);
	}

	public Categoria atualizarCategoria(int id, String descricao) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent()) {
			categoria.get().setDescricao(descricao);
			return categoriaRepository.save(categoria.get());
		}
		return null;
	}

	public boolean deletarCategoria(int id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent()) {
			categoriaRepository.delete(categoria.get());
			return true;
		}
		return false;
	}

}
