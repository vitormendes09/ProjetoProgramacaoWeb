package iff.edu.br.imobiliaria.service;

import iff.edu.br.imobiliaria.entidades.Proprietario;

import iff.edu.br.imobiliaria.repository.ProprietarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	public Proprietario adicionarProprietario(String nome, String email, String cpf, String telefone, String endereco) {
		Proprietario proprietario = proprietarioRepository.buscarPorCPF(cpf);

		if (proprietario == null) {
			Proprietario novoProprietario = new Proprietario(nome, email,cpf,telefone);
			proprietarioRepository.save(novoProprietario);
			return novoProprietario;
		}
		return null;
	}
	
	public String deletarProprietario(String cpf) {
		Proprietario proprietarioExistente = proprietarioRepository.buscarPorCPF(cpf);

		if (proprietarioExistente != null) {
			proprietarioRepository.delete(proprietarioExistente);
			return "Proprietario deletado.";
		} else {
			return "Proprietario não deletado.";
		}
	}
	
	//CriarLista de Imoveis
	
}
