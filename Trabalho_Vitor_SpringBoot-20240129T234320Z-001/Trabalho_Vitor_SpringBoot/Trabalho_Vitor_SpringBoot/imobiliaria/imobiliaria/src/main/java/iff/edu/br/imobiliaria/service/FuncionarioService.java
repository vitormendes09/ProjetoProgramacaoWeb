package iff.edu.br.imobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iff.edu.br.imobiliaria.entidades.Funcionario;

import iff.edu.br.imobiliaria.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario adicionarFuncionario(String nome, String email ,String cpf, String telefone) {
		Funcionario funcionario = funcionarioRepository.buscarPorCPF(cpf);

		if (funcionario == null) {
			Funcionario novoFuncaionario = new Funcionario(nome, email, cpf, telefone);
			funcionarioRepository.save(novoFuncaionario);
			return novoFuncaionario;
		}
		return null;
	}
	
	public String deletarFuncionario(String cpf) {
		Funcionario funcionarioExistente = funcionarioRepository.buscarPorCPF(cpf);

		if (funcionarioExistente != null) {
			funcionarioRepository.delete(funcionarioExistente);
			return "Funcionario deletado.";
		} else {
			return "Funcionario não deletado.";
		}
	}
	
}
