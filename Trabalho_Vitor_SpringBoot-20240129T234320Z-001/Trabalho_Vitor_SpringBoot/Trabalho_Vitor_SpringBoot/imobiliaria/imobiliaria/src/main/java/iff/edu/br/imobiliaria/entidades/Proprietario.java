package iff.edu.br.imobiliaria.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;
import java.util.ArrayList;

@Entity

public class Proprietario extends Usuario{

	private String endereco;
	private List<Imovel> imovel;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Proprietario() {
		super();

	}

	public Proprietario(String nome, String email, String cpf, String telefone) {
		super(nome, email, cpf, telefone);
		this.imovel = new ArrayList<>();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void adicionarPedido(Imovel imovel) {
		this.imovel.add(imovel);
	}
	
	public void removerPedido(Imovel imovel) {
		this.imovel.remove(imovel);
	}

    public List<Imovel> getPedido() {
        return imovel;
    }
	
	
}
