package iff.edu.br.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iff.edu.br.imobiliaria.entidades.Imovel;



public interface ImovelRepository extends JpaRepository <Imovel, Long> {
	
	@Query(value = "SELECT * FROM Proprietario WHERE endereco = ?1", nativeQuery = true)
    Imovel buscarPorEndereco(String endereco);
}
