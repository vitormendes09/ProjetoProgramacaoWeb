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

import iff.edu.br.imobiliaria.entidades.Usuario;
import iff.edu.br.imobiliaria.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioRestController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("")
	@ResponseBody
	public String adicionarUsuario(@RequestAttribute String nome, @RequestParam String email,
			@RequestParam String cpf, @RequestParam String telefone) {
		Usuario resultado = usuarioService.adicionarUsuario(nome, email, cpf, telefone);
		return resultado != null ? "Usuário cadastrado com sucesso." : "Erro: Usuário já ";
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletarUsuario(@PathVariable("cpf") String cpf) {
		return usuarioService.deletarUsuario(cpf);
	}
}
