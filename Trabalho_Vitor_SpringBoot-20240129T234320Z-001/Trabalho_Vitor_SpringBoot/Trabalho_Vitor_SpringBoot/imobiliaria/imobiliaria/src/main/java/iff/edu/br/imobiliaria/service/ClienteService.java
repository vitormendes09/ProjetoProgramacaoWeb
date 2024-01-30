package iff.edu.br.imobiliaria.service;

import iff.edu.br.imobiliaria.entidades.Usuario;
import iff.edu.br.imobiliaria.entidades.Cliente;

import iff.edu.br.imobiliaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public String adicionarCliente( String nome, String email, String cpf, String telefone, double saldo) {
		Cliente novoCliente = new Cliente(nome, email, cpf, telefone, saldo );
		
		Cliente clienteExistente = clienteRepository.buscarPorCPF(novoCliente.getCpf());

		if (clienteExistente == null) {
			Usuario novoUsuario = usuarioService.adicionarUsuario(nome, email, cpf, telefone);

			if (novoUsuario != null) {
				novoCliente.setUsuario(novoUsuario);
				clienteRepository.save(novoCliente);
				return "Usuario adicionado";
			} else {
				return "Usuario não encontrado";
			}
		} else {
			return "Usuario já cadastrado";
		}
	}
	
	public String deletarCliente(String cpf) {
		Cliente clienteExistente = clienteRepository.buscarPorCPF(cpf);

		if (clienteExistente != null) {
			clienteRepository.delete(clienteExistente);
			return "cliente deletado.";
		} else {
			return "cliente não deletado.";
		}
	}
	
	public String atualizarCliente(Long id, String nome, String email, String cpf, String telefone, double saldo ) {
		Cliente clienteExistente = buscarCliente(cpf);

		if (clienteExistente != null) {
			clienteExistente.setCpf(cpf);
			clienteExistente.setNome(nome);
			clienteExistente.setEmail(email);
			clienteExistente.setId(id);
			clienteExistente.setTelefone(telefone);
			clienteExistente.setSaldo(saldo);
			clienteRepository.save(clienteExistente);
			return "Cliente atualizado com sucesso.";
		} else {
			return "Cliente não encontrado.";
		}
	}
	
	public Cliente buscarCliente(String cpf) {
		return clienteRepository.buscarPorCPF(cpf);
	}
}
