package br.org.com.recode.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.org.com.recode.model.Cliente;

public class ClienteDTO {
	
	private long id;
	private String cpf, nome, tel, senha, email, end;
		
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.tel = cliente.getTel();
		this.senha = cliente.getSenha();
		this.email = cliente.getEmail();
		this.end = cliente.getEnd();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getEnd() {
		return end;
	}

	public void setEnd(String endereco) {
		this.end = endereco;
	}

	public static List<ClienteDTO> converter(List<Cliente> cliente){
		return cliente.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}
	
}
