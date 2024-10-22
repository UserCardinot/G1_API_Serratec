package br.com.grupo1.gp1_api.security.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	List<Pedido> findAll();
	
	Optional<Pedido> findByCliente(String cliente);

}
