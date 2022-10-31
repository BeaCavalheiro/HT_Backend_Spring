package br.org.com.recode.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeComp, aerRod, nEmbarque;
	private double valor;
	private Cliente cliente;
	private Transporte transporte;
	private Hospedagem hospedagem;
	private Destino destino;
	
	public Reserva() {
		super();
	}

	public Reserva(long id, String nomeComp, String aerRod, String nEmbarque, double valor, Cliente cliente,
			Transporte transporte, Hospedagem hospedagem, Destino destino) {
		super();
		this.id = id;
		this.nomeComp = nomeComp;
		this.aerRod = aerRod;
		this.nEmbarque = nEmbarque;
		this.valor = valor;
		this.cliente = cliente;
		this.transporte = transporte;
		this.hospedagem = hospedagem;
		this.destino = destino;
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

	public String getnEmbarque() {
		return nEmbarque;
	}

	public void setnEmbarque(String nEmbarque) {
		this.nEmbarque = nEmbarque;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
}
