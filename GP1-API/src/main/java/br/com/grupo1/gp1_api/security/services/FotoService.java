package br.com.grupo1.gp1_api.security.services;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.grupo1.gp1_api.security.entities.Foto;
import br.com.grupo1.gp1_api.security.entities.User;
import br.com.grupo1.gp1_api.security.repositories.FotoRepository;


@Service
public class FotoService {

	@Autowired
	FotoRepository fotoRepository;

	public Foto cadastrarFoto(MultipartFile foto, User user) throws IOException{
		Foto fotoUsuario = new Foto();
		fotoUsuario.setDados(foto.getBytes());
		fotoUsuario.setTipo(foto.getContentType());
		fotoUsuario.setNome(foto.getOriginalFilename());
		fotoUsuario.setUser(user);
		fotoUsuario.setUrl(addImgUri(user));
		return fotoRepository.save(fotoUsuario);
	}

	private String addImgUri(User user) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/{id}/foto")
                .buildAndExpand(user.getId()).toUri();
		
		return uri.toString();
	}
	
	@Transactional(readOnly = true)
	public byte[] getFoto(Integer id) throws Exception {
		Foto newFoto = fotoRepository.buscarFotoByIdUser(id);
		
		if(newFoto == null) {
			throw new Exception("Foto não encontrado para usuario com id: " + id);
		}
		return newFoto.getDados();
	}
}