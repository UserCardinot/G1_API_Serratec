package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.ClienteDTO;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.User;
import br.com.grupo1.gp1_api.security.repositories.ClienteRepository;
import br.com.grupo1.gp1_api.security.repositories.UserRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	UserRepository userRepository;

	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public ClienteDTO pesquisarCliente(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		ClienteDTO clienteDto = new ClienteDTO();
		clienteDto.setNome(cliente.get().getNome());
		clienteDto.setCpf(cliente.get().getCpf());

		return clienteDto;
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public void deletarCliente(Integer id) {
		clienteRepository.deleteById(id);
	}

	public Cliente atualizarCliente(Integer id, ClienteDTO clienteDto) {
		Optional<Cliente> clienteUpdate = clienteRepository.findById(id);

		if (clienteUpdate.isPresent()) {
			Cliente cliente = clienteUpdate.get();
			cliente.setNome(clienteDto.getNome());
			cliente.setCpf(clienteDto.getCpf());
			return clienteRepository.save(cliente);
		} else {
			throw new RuntimeException("ID não encontrado");
		}
	}

	public List<Cliente> buscarIdPorUsuario(String username) {
		Optional<User> usuario = userRepository.findByUsername(username.trim()); 
        return clienteRepository.findByUser(usuario.get());
//                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o nome de usuário: " + username))
//                .getId();
	}
}
