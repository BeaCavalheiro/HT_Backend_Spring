package br.org.com.recode.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transporte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeComp, aerRod, nEmbarque;
	private double valor;
		
	public Transporte() {
	}
	public Transporte(long id, String nomeComp, String aerRod, String nEmbarque, double valor) {
		this.id = id;
		this.nomeComp = nomeComp;
		this.aerRod = aerRod;
		this.nEmbarque = nEmbarque;
		this.valor = valor;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeComp() {
		return nomeComp;
	}
	public void setNomeComp(String nomeComp) {
		this.nomeComp = nomeComp;
	}
	public String getAerRod() {
		return aerRod;
	}
	public void setAerRod(String aerRod) {
		this.aerRod = aerRod;
	}
	public String getNEmbarque() {
		return nEmbarque;
	}
	public void setNEmbarque(String nEmbarque) {
		this.nEmbarque = nEmbarque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(nEmbarque, id, nomeComp, aerRod,valor);
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
		Transporte other = (Transporte) obj;
		return Objects.equals(aerRod, other.aerRod) && id == other.id && Objects.equals(nomeComp, other.nomeComp)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor)
				&& Objects.equals(nEmbarque, other.nEmbarque);
	}
	
	
}
