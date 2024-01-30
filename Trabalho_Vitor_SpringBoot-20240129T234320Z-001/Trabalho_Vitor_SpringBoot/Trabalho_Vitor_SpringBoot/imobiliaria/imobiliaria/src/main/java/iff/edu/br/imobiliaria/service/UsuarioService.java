package iff.edu.br.imobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iff.edu.br.imobiliaria.entidades.Usuario;
import iff.edu.br.imobiliaria.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario adicionarUsuario(String nome, String email, String cpf, String telefone) {
		Usuario usuario = usuarioRepository.buscarPorCPF(cpf);

		if (usuario == null) {
			Usuario novoUsuario = new Usuario(nome, email,cpf,telefone);
			usuarioRepository.save(novoUsuario);
			return novoUsuario;
		}
		return null;
	}
	
	public String deletarUsuario(String cpf) {
		Usuario usuarioExistente = usuarioRepository.buscarPorCPF(cpf);

		if (usuarioExistente != null) {
			usuarioRepository.delete(usuarioExistente);
			return "Usuário deletado.";
		} else {
			return "Usuário não deletado.";
		}
	}
	

}
