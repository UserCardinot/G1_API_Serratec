package br.com.grupo1.gp1_api.security.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.grupo1.gp1_api.security.dto.EnderecoRequestDTO;
import br.com.grupo1.gp1_api.security.dto.EnderecoResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> criarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoResponseDTO response = enderecoService.salvarEndereco(enderecoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listarEnderecos() {
        List<EnderecoResponseDTO> enderecos = enderecoService.listarEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> buscarEnderecoPorId(@PathVariable Long id) {
        EnderecoResponseDTO endereco = enderecoService.buscarPorId(id);
        return ResponseEntity.ok(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoResponseDTO atualizado = enderecoService.atualizarEndereco(id, enderecoRequestDTO);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
