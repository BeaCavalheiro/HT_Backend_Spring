package br.org.com.recode.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.com.recode.model.Funcionario;
import br.org.com.recode.repository.FuncionarioRepository;

@Service
public class FuncionarioAutenticacaoService implements UserDetailsService {

	@Autowired
	private FuncionarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Funcionario> user = userRepository.findByEmail(username);
		if (user.isPresent()) {
			System.out.println("AutenticacaoService Achou");
			return user.get();
		}

		throw new UsernameNotFoundException("DADOS INVALIDOS");

	}

}
