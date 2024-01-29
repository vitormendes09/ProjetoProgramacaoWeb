package iff.edu.br.imobiliaria.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Imovel {
	
	
	private double valor;
	private String descricao;
	private String endereco;
	
	public Imovel(double valor, String descricao, String endereco, Proprietario proprietario) {
		super();
		this.valor = valor;
		this.descricao = descricao;
		this.endereco = endereco;
		this.proprietario = proprietario;
	}
	
	public Imovel() {
		
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@ManyToOne
	@JoinColumn(name = "id_proprietario")
	private Proprietario proprietario;

}
