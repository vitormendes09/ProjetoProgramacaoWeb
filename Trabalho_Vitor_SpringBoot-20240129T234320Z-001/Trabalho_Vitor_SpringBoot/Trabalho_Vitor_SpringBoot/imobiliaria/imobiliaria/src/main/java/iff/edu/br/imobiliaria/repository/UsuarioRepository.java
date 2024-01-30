package iff.edu.br.imobiliaria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iff.edu.br.imobiliaria.entidades.Usuario;

public interface UsuarioRepository  extends JpaRepository <Usuario, Long>{

    @Query(value = "SELECT * FROM Usuario WHERE cpf = ?1", nativeQuery = true)
    Usuario buscarPorCPF(String cpf);



}	
