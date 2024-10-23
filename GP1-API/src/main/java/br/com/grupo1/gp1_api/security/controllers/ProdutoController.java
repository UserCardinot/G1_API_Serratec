package br.com.grupo1.gp1_api.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.ProdutoDTO;
import br.com.grupo1.gp1_api.security.entities.Produto;
import br.com.grupo1.gp1_api.security.repositories.ProdutoRepository;
import br.com.grupo1.gp1_api.security.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;
    
    @Autowired
    ProdutoService produtoService;
    
    @PostMapping
    public ResponseEntity<Produto> produtoDto(@RequestBody ProdutoDTO produtoDto) {
		Produto newProduto = produtoService.criarProduto(produtoDto);
		return ResponseEntity.ok(newProduto);
    }

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{nome}")
    public Produto getProdutoByNome(String nome) {
        return produtoRepository.findByNome(nome).get();
    }
    
    @GetMapping("/{id}")
	public ProdutoDTO getProdutoById(@PathVariable Integer id) {
		return produtoService.getProdutoById(id);
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
	}
    
	@PutMapping("/{id}")
	 public ResponseEntity<Produto>atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDto){
		Produto produtoAtualizado = produtoService.atualizarProduto(id, produtoDto);
		return ResponseEntity.ok(produtoAtualizado);
	 } 
}