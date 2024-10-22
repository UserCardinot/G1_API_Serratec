package br.com.grupo1.gp1_api.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.entities.Pedido;
import br.com.grupo1.gp1_api.security.repositories.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }
}