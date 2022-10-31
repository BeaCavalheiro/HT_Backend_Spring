package br.org.com.recode.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.org.com.recode.controller.dto.FuncionarioDTO;
import br.org.com.recode.controller.form.FunForm;
import br.org.com.recode.model.Funcionario;
import br.org.com.recode.repository.FuncionarioRepository;

@Controller
@ResponseBody
@RequestMapping("/")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository userRepository;



	@GetMapping("/user/listar")
	public List<FuncionarioDTO> lista() {
		List<Funcionario> users = userRepository.findAll();
		return FuncionarioDTO.converter(users);
	}

	@GetMapping("/user/listar/{id}")
	public FuncionarioDTO detalhar(@PathVariable Long id) {
		Funcionario user = userRepository.getReferenceById(id);
		return new FuncionarioDTO(user);
	}

	@DeleteMapping("/user/remove/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		userRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/user/cadastrar")
	public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody @Valid FunForm form, UriComponentsBuilder uriBuilder) {

		Optional<Funcionario> users = userRepository.findByEmail(form.getEmail());

		if (users.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Funcionario user = form.converter(encoder);
			userRepository.save(user);
			URI uri = uriBuilder.path("/user/cadastrar/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new FuncionarioDTO(user));
		}

	}
}
