package iff.edu.br.imobiliaria.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
public abstract class Cargo {
	
	private String funcao;
	private double salario;
	
	public Cargo(String funcao, double salario) {
		this.funcao = funcao;
		this.salario = salario;
	}
	
	public Cargo() {

	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
