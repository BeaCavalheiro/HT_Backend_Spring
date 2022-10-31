package br.org.com.recode.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.org.com.recode.model.Funcionario;

public class FunForm {

	@NotNull
	@NotEmpty
	@NotBlank
	private String nome;
	@NotNull
	@NotEmpty
	@NotBlank
	private String cargo;
	@NotNull
	@NotEmpty
	@NotBlank
	private String email;
	@NotNull
	@NotEmpty
	@NotBlank
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Funcionario converter(BCryptPasswordEncoder encoder) {

		this.setSenha(encoder.encode(senha));
		return new Funcionario(nome,cargo, email, senha);
	}
}
