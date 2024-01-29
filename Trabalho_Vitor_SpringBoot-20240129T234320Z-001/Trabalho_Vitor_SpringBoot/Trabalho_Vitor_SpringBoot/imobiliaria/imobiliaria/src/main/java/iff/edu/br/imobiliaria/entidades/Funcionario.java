package iff.edu.br.imobiliaria.entidades;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class Funcionario extends Usuario {
	
	 @NotBlank(message = "Não pode ser em branco ou nulo")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String email, String cpf, String telefone) {
		super(nome, email, cpf, telefone);
		
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
