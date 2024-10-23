package br.com.grupo1.gp1_api.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.EnderecoRequestDTO;
import br.com.grupo1.gp1_api.security.dto.EnderecoResponseDTO;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.Endereco;
import br.com.grupo1.gp1_api.security.repositories.ClienteRepository;
import br.com.grupo1.gp1_api.security.repositories.EnderecoRepository;
import br.com.grupo1.gp1_api.utils.Util;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private Util util;
	
	@Autowired
	ClienteRepository clienteRepository;

	public EnderecoResponseDTO salvarEndereco(EnderecoRequestDTO enderecoRequest) {
		Optional<Cliente> cliente = clienteRepository.findById(enderecoRequest.getIdCliente());
		
		EnderecoResponseDTO viaCep = util.buscarEndereco(enderecoRequest.getCep());
		Endereco novoEndereco = new Endereco();

		novoEndereco.setLogradouro(viaCep.getLogradouro());
		novoEndereco.setLocalidade(viaCep.getLocalidade());
		novoEndereco.setUf(viaCep.getUf());
		novoEndereco.setBairro(viaCep.getBairro());

		novoEndereco.setNumero(enderecoRequest.getNumero());
		novoEndereco.setComplemento(enderecoRequest.getComplemento());
		novoEndereco.setCep(enderecoRequest.getCep());

		enderecoRepository.save(novoEndereco);
		cliente.get().setEndereco(novoEndereco);
		clienteRepository.save(cliente.get());

		viaCep.setId(novoEndereco.getId());
		viaCep.setNumero(enderecoRequest.getNumero());
		viaCep.setComplemento(enderecoRequest.getComplemento());
		return viaCep;
	}
}