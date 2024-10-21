package br.com.grupo1.gp1_api.security.services;

import br.com.grupo1.gp1_api.security.dto.EnderecoRequestDTO;
import br.com.grupo1.gp1_api.security.dto.EnderecoResponseDTO;
import br.com.grupo1.gp1_api.security.entities.Endereco;
import br.com.grupo1.gp1_api.security.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoResponseDTO salvarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoRequestDTO.getRua());
        endereco.setNumero(enderecoRequestDTO.getNumero());
        endereco.setCidade(enderecoRequestDTO.getCidade());
        endereco.setEstado(enderecoRequestDTO.getEstado());
        endereco.setCep(enderecoRequestDTO.getCep());

        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO();
        enderecoResponseDTO.setId(enderecoSalvo.getId());
        enderecoResponseDTO.setRua(enderecoSalvo.getRua());
        enderecoResponseDTO.setNumero(enderecoSalvo.getNumero());
        enderecoResponseDTO.setCidade(enderecoSalvo.getCidade());
        enderecoResponseDTO.setEstado(enderecoSalvo.getEstado());
        enderecoResponseDTO.setCep(enderecoSalvo.getCep());

        return enderecoResponseDTO;
    }
}