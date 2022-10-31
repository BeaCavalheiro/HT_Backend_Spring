package br.org.com.recode.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.org.com.recode.model.Funcionario;

public class FuncionarioDTO {
	
	private long id;
	private String senha, email, nome, cargo;
	
	public FuncionarioDTO() {
		super();
	}

	public FuncionarioDTO(Funcionario fun) {
		super();
		this.id = fun.getId();
		this.senha = fun.getSenha();
		this.email = fun.getEmail();
		this.nome = fun.getNome();
		this.cargo = fun.getCargo();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return nome;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public static List<FuncionarioDTO> converter(List<Funcionario> fun){
		return fun.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
	}
	
}
