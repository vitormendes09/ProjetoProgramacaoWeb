package iff.edu.br.imobiliaria.controller.apirest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iff.edu.br.imobiliaria.entidades.Cargo;
import iff.edu.br.imobiliaria.entidades.Funcionario;
import iff.edu.br.imobiliaria.entidades.Proprietario;
import iff.edu.br.imobiliaria.service.FuncionarioService;



@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("")
	@ResponseBody
	public String Cadastrarfuncionario(@RequestAttribute String nome, @RequestParam String email,
			@RequestParam String cpf, @RequestParam String telefone,@RequestParam Cargo cargo ) {
		Funcionario funcionario = funcionarioService.adicionarFuncionario(nome, email, cpf, telefone);
		return funcionario != null ? "funcionario cadastrado com sucesso." : "Erro: Funcionario já cadastrado ";
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletarFuncionario(@PathVariable("cpf") String cpf) {
		return funcionarioService.deletarFuncionario(cpf);
	}
	
	
}
