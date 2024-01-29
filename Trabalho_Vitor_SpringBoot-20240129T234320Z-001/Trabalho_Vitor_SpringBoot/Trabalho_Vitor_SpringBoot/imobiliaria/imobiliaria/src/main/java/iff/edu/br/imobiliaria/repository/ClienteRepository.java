package iff.edu.br.imobiliaria.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import iff.edu.br.imobiliaria.entidades.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{


   
}
