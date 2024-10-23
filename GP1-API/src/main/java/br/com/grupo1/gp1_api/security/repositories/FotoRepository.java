package br.com.grupo1.gp1_api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	


}
