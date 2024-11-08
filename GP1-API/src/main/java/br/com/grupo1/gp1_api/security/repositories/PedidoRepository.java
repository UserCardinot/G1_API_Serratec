package br.com.grupo1.gp1_api.security.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Carrinho;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	List<Pedido> findByCliente(Cliente cliente);

	Boolean existsByDataPedido(LocalDate dataPedido);

	Boolean existsByStatus(String status);

	Boolean existsByNf(Long nf);

	Optional<Pedido> findByCarrinho(Carrinho carrinho);

}
