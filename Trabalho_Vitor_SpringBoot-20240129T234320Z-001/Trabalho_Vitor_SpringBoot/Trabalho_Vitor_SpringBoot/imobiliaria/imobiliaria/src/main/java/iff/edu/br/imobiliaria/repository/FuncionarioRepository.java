package iff.edu.br.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iff.edu.br.imobiliaria.entidades.Funcionario;


public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{
	
	
}
