package br.org.com.recode.controller.dto;

import org.springframework.security.core.Authentication;

import br.org.com.recode.model.Funcionario;

public class FuncionarioTokenDTO {
	
	private Long idUser;
	private String emailUser;

	private String token;
	private String tipo;

	public FuncionarioTokenDTO(String token, String tipo, Authentication authentication) {
		Funcionario logado = (Funcionario) authentication.getPrincipal();
		this.token = token;
		this.tipo = tipo;

		this.idUser = logado.getId();
		this.emailUser = logado.getEmail();

	}

	public String getToken() {
		return this.token;
	}

	public String getTipo() {
		return this.tipo;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public String getEmailUser() {
		return this.emailUser;
	}
}
