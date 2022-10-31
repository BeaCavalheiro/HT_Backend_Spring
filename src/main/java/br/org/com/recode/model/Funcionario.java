package br.org.com.recode.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Funcionario implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome, cargo, email, senha;
		

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cargo,String email, String senha) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.email = email;
		this.senha = senha;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public Funcionario id(long id) {
		setId(id);
		return this;
	}

	public Funcionario nome(String nome) {
		setNome(nome);
		return this;
	}

	public Funcionario tel(String cargo) {
		setCargo(cargo);
		return this;
	}

	public Funcionario senha(String senha) {
		setSenha(senha);
		return this;
	}

	public Funcionario email(String email) {
		setEmail(email);
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash( id, nome, cargo, perfis,email, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return id == other.id && Objects.equals(nome, other.nome) 
				&& Objects.equals(cargo, other.cargo) &&Objects.equals(email, other.email)
				&&  Objects.equals(perfis, other.perfis)&& Objects.equals(senha, other.senha);
	}


	@Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return this.perfis;
	  }

	  @Override
	  public String getPassword() {
	    return this.senha;
	  }

	  @Override
	  public String getUsername() {
	    return this.email;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

}
