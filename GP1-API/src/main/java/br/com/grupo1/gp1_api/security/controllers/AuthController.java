package br.com.grupo1.gp1_api.security.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.gp1_api.security.dto.JwtResponseDTO;
import br.com.grupo1.gp1_api.security.dto.LoginRequestDTO;
import br.com.grupo1.gp1_api.security.dto.MessageResponseDTO;
import br.com.grupo1.gp1_api.security.dto.SignupRequestDTO;
import br.com.grupo1.gp1_api.security.entities.Cliente;
import br.com.grupo1.gp1_api.security.entities.Funcionario;
import br.com.grupo1.gp1_api.security.entities.Role;
import br.com.grupo1.gp1_api.security.entities.User;
import br.com.grupo1.gp1_api.security.enums.RoleEnum;
import br.com.grupo1.gp1_api.security.jwt.JwtUtils;
import br.com.grupo1.gp1_api.security.repositories.RoleRepository;
import br.com.grupo1.gp1_api.security.repositories.UserRepository;
import br.com.grupo1.gp1_api.security.services.ClienteService;
import br.com.grupo1.gp1_api.security.services.FuncionarioService;
import br.com.grupo1.gp1_api.security.services.UserDetailsImpl;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	ClienteService clienteService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponseDTO(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestDTO signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Username já utilizado!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
		}

		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role clienteRole = roleRepository.findByName(RoleEnum.ROLE_CLIENTE)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			roles.add(clienteRole);

			user.setRoles(roles);
			userRepository.save(user);

			Cliente novoCliente = new Cliente();
			novoCliente.setNome(signUpRequest.getNomeCompleto().trim());
			novoCliente.setUser(user);
			clienteService.cadastrarCliente(novoCliente);

		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "funcionário":
					Role funcionarioRole = roleRepository.findByName(RoleEnum.ROLE_FUNCIONARIO)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(funcionarioRole);

					user.setRoles(roles);
					userRepository.save(user);

					Funcionario novoFuncionario = new Funcionario();
					novoFuncionario.setCargo("admin");
					novoFuncionario.setUser(user);
					novoFuncionario.setNome(signUpRequest.getNomeCompleto().trim());
					novoFuncionario.setSalario(3000.);
					funcionarioService.save(novoFuncionario);

					break;
				default:
					Role clienteRole = roleRepository.findByName(RoleEnum.ROLE_CLIENTE)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(clienteRole);

					user.setRoles(roles);
					userRepository.save(user);

					Cliente novoCliente = new Cliente();
					novoCliente.setNome(signUpRequest.getNomeCompleto().trim());
					novoCliente.setUser(user);
					clienteService.cadastrarCliente(novoCliente);
				}
			});
		}

		return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
	}
}
