package br.com.grupo1.gp1_api.security.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.PedidoRequestDTO;
import br.com.grupo1.gp1_api.security.dto.PedidoResponseDTO;
import br.com.grupo1.gp1_api.security.entities.Pedido;
import br.com.grupo1.gp1_api.security.repositories.PedidoRepository;
import br.com.grupo1.gp1_api.security.services.EmailService;
import br.com.grupo1.gp1_api.security.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PedidoService pedidoService;

	@Autowired
	EmailService emailService;

	@GetMapping
	public ResponseEntity<List<Pedido>> getPedidos() {
		try {
			List<Pedido> pedidos = pedidoRepository.findAll();

			emailService.emailPersonalizadoPedido();

			return ResponseEntity.ok(pedidos);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@PostMapping
	public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody PedidoRequestDTO pedidoRequest,
			@AuthenticationPrincipal UserDetails userDetails) {

		Integer idCliente = pedidoService.obterIdClientePeloUsuario(userDetails.getUsername());

		Pedido novoPedido = pedidoService.criarPedido(pedidoRequest, idCliente);

		PedidoResponseDTO responseDTO = new PedidoResponseDTO(novoPedido.getId(), novoPedido.getStatus(),
				novoPedido.getCarrinho().getId(), novoPedido.getCliente().getId());

		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizarPedido(@PathVariable Integer id, String status) {
		Pedido pedido = pedidoService.atualizarPedido(id, status);
		return ResponseEntity.ok(pedido);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarPedido(@PathVariable Integer id) {
		pedidoService.deletarPedido(id);
		return ResponseEntity.ok("Pedido deletado com sucesso!");
	}

}