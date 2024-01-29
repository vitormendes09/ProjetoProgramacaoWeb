package iff.edu.br.imobiliaria.controller.apirest;


import iff.edu.br.imobiliaria.entidades.Cliente;
import iff.edu.br.imobiliaria.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping("")
	@ResponseBody
	public String adicionarCliente(@RequestAttribute String nome, @RequestParam String email,
			@RequestParam String cpf, @RequestParam String telefone,@RequestParam  double saldo) {
		String cliente = clienteService.adicionarCliente(nome, email, cpf, telefone, saldo);
		return cliente != null ? "Cliente cadastrado com sucesso." : "Erro: Cliente já cadastrado ";
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletarCliente(@PathVariable("cpf") String cpf) {
		return clienteService.deletarCliente(cpf);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public String atualizarCliente(@PathVariable("id") Long id, String nome, String email, String cpf, String telefone, double saldo) {
		return clienteService.atualizarCliente( id,  nome,  email,  cpf,  telefone,  saldo );
	}
	
}

