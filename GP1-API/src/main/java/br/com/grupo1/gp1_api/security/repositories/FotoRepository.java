package br.com.grupo1.gp1_api.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.grupo1.gp1_api.security.entities.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	@Query(value = "select * from foto where user_id = :idUser", nativeQuery = true)
	Foto buscarFotoByIdUser(Integer idUser);
	
	


}
