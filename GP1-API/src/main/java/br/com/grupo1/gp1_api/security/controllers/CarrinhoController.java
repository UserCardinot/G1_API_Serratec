package br.com.grupo1.gp1_api.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.CarrinhoRequestDTO;
import br.com.grupo1.gp1_api.security.dto.CarrinhoResponseDTO;
import br.com.grupo1.gp1_api.security.entities.Carrinho;
import br.com.grupo1.gp1_api.security.services.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	CarrinhoService carrinhoService;

	@GetMapping("/{idCliente}")
	public ResponseEntity<?> exibirCarrinhoByIdCliente(@PathVariable int idCliente) {
		CarrinhoResponseDTO	 carrinho = carrinhoService.exibirCarrinhoByIdCliente(idCliente);

		if (carrinho == null) {
			return ResponseEntity.badRequest()
					.body("Erro: Cliente de id " + idCliente + " não encontrado ou o carrinho está vazio!");
		}
		return ResponseEntity.ok(carrinho);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarCarrinho(@RequestBody CarrinhoRequestDTO carrinhoRequest) {
		System.out.println(carrinhoRequest.getIdCliente());
		Carrinho novoCarrinho = carrinhoService.cadastrarCarrinho(carrinhoRequest);

		if (novoCarrinho == null) {
			return ResponseEntity.badRequest().body("Erro: Cliente de id " + carrinhoRequest.getIdCliente() + " não encontrado ou produto de id " + carrinhoRequest.getIdProduto()+" não encontrado");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCarrinho);
	}
	
//	@DeleteMapping
}
