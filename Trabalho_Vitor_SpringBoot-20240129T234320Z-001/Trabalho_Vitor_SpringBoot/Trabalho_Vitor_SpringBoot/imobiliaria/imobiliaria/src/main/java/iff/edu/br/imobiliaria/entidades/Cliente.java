package iff.edu.br.imobiliaria.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Cliente extends Usuario {
	
	private double saldo;
	
	public Cliente() {
		super();
		
	}

	public Cliente(String nome, String email, String cpf, String telefone, double saldo) {
		super(nome, email, cpf, telefone);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
}
