package br.com.grupo1.gp1_api.security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	Optional<Funcionario> findByNome(String nome);

	Boolean existsByNome(String nome);

	Boolean existsBySalario(Double salario);

	Boolean existsByCargo(String Cargo);
}
