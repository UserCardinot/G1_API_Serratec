package br.com.grupo1.gp1_api.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.entities.Categoria;
import br.com.grupo1.gp1_api.security.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategorias() {
		return ResponseEntity.ok(categoriaService.listarCategorias());
	}

	@PostMapping
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestParam String descricao) {
		Categoria novaCategoria = categoriaService.cadastrarCategoria(descricao);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCategoria(@PathVariable int id, String descricao) {
		Categoria categoriaAtualizada = categoriaService.atualizarCategoria(id, descricao);
		if (categoriaAtualizada == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Não foi possível encontrar a categoria de id: " + id);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarCategoria(@PathVariable int id) {
		if (categoriaService.deletarCategoria(id)) {
			return ResponseEntity.ok("Categoria deletada com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Não foi possível encontrar a categoria de id: " + id);
		}
	}

}
