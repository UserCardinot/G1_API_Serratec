package br.com.grupo1.gp1_api.security.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.User;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Optional<Cliente> findByNome(String nome);

	boolean existsByNome(String nome);

	List<Cliente> findAll();

	List<Cliente> findByUser(User user);
}
