package br.org.com.recode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.recode.model.Cliente;
import br.org.com.recode.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	Optional<Funcionario> findByEmail(String email);
	Funcionario findByNome(String nomeUser);
}
