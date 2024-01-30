package iff.edu.br.imobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iff.edu.br.imobiliaria.entidades.Imovel;
import iff.edu.br.imobiliaria.entidades.Proprietario;
import iff.edu.br.imobiliaria.repository.ImovelRepository;

@Service
public class ImovelService {
	@Autowired
	private ImovelRepository imovelRepository;
	
	
	public Imovel adicionarImovel(double valor, String descricao, String endereco, Proprietario proprietario) {
		Imovel imovel = imovelRepository.buscarPorEndereco(endereco);

		if (imovel == null) {
			Imovel novoImovel = new Imovel(valor, descricao, endereco, proprietario);
			imovelRepository.save(novoImovel);
			return novoImovel;
		}
		return null;
	}
	
	
	public String deletarImovel(String endereco) {
		Imovel imovelExistente = imovelRepository.buscarPorEndereco(endereco);

		if (imovelExistente != null) {
			imovelRepository.delete(imovelExistente);
			return "imovel deletado.";
		} else {
			return "Imovel não deletado.";
		}
	}
}
