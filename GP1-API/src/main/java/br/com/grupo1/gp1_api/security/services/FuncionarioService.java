package br.com.grupo1.gp1_api.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo1.gp1_api.security.dto.FuncionarioRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Funcionario;
import br.com.grupo1.gp1_api.security.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }
    
    public Funcionario findByNome(String nome) {
        return funcionarioRepository.findByNome(nome).get();
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }  
    
    public Funcionario atualizarFuncionario(int id, FuncionarioRequestDTO funcionarioRequest ) {
    	
    	Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
    	 
    	if(funcionario.isPresent()) {
    		funcionario.get().setNome(funcionarioRequest.getNome());
    		funcionario.get().setTelefone(funcionarioRequest.getTelefone());
    		return funcionarioRepository.save(funcionario.get());
    	}else {
    		return null;
    	}
    }
    
    public boolean deletarFuncionario(int id) {

    	Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
    	 
    	if(funcionario.isPresent()) {
    		 funcionarioRepository.delete(funcionario.get());
    		 return true;
    	}else {
    		return false;
    	}
    }
}