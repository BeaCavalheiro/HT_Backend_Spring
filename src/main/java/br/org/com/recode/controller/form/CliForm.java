package br.org.com.recode.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.org.com.recode.model.Cliente;

public class CliForm {

	@NotNull
	@NotEmpty
	@NotBlank
	private String cpf;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String nome;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String end;
	
	@NotNull
	@NotEmpty
	private String tel;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String email;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String senha;
	
		
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	
	
	
	public Cliente converter(BCryptPasswordEncoder encoder) {

	    this.setSenha(encoder.encode(senha));
	    return new Cliente(cpf, nome, end, tel, senha, email);
	  }
}
