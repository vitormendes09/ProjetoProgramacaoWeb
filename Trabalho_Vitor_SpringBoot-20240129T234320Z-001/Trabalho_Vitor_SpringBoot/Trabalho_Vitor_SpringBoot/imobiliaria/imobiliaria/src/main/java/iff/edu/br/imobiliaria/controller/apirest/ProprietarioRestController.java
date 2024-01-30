package iff.edu.br.imobiliaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iff.edu.br.imobiliaria.entidades.Proprietario;
import iff.edu.br.imobiliaria.service.ProprietarioService;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioRestController {
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@PostMapping("")
	@ResponseBody
	public String adicionarProprietario(@RequestAttribute String nome, @RequestParam String email,
			@RequestParam String cpf, @RequestParam String telefone, @RequestParam String endereco ) {
		Proprietario resultado = proprietarioService.adicionarProprietario( nome, email, cpf, telefone, endereco);
		return resultado != null ? "Proprietario cadastrado com sucesso." : "Erro: Proprietario já cadastrado ";
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletarProprietario(@PathVariable("cpf") String cpf) {
		return proprietarioService.deletarProprietario(cpf);
	}
}
