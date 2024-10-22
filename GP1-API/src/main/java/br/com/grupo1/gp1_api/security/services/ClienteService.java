package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.ClienteDTO;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteDTO pesquisarCliente(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		ClienteDTO clienteDto = new ClienteDTO();
		clienteDto.setNome(cliente.get().getNome());
		clienteDto.setCpf(cliente.get().getCpf());
		;

		return clienteDto;
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

}
