package br.org.com.recode.model;

import java.util.Arrays;
	import java.util.Objects;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Lob;
	
	@Entity
public class Destino {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String nome, descricao ;
		private double passeio;
		
		@Lob
		private byte[] imagem;
		
		public Destino() {
		}
		public Destino(long id, String nome, String descricao, double passeio) {
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.passeio = passeio;
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
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		public double getPasseio() {
			return passeio;
		}
		public void setPasseio(double passeio) {
			this.passeio = passeio;
		}
		public byte[] getImagem() {
			return imagem;
		}
		public void setImagem(byte[] imagem) {
			this.imagem = imagem;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(imagem);
			result = prime * result + Objects.hash(id, nome, descricao, passeio);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Destino other = (Destino) obj;
			return id == other.id && Arrays.equals(imagem, other.imagem) && Objects.equals(nome, other.nome)
					&& Objects.equals(descricao, other.descricao)
					&& Double.doubleToLongBits(passeio) == Double.doubleToLongBits(other.passeio);
		}
		
		
}
