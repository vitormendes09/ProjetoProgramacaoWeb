package iff.edu.br.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iff.edu.br.imobiliaria.entidades.Imovel;



public interface ImovelRepository extends JpaRepository <Imovel, Long> {
	
}
