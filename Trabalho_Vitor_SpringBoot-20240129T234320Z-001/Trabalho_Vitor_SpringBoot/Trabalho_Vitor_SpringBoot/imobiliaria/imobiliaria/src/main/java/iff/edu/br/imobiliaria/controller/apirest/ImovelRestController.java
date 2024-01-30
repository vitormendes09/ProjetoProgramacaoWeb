package iff.edu.br.imobiliaria.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iff.edu.br.imobiliaria.entidades.Imovel;
import iff.edu.br.imobiliaria.entidades.Proprietario;
import iff.edu.br.imobiliaria.service.ImovelService;

@RestController
@RequestMapping("/imovel")
public class ImovelRestController {
	
	@Autowired
	private ImovelService imovelService;
	
	@PostMapping("")
	@ResponseBody
	public String CadastrarImovel(double valor, String descricao, String endereco, Proprietario proprietario ) {
		Imovel imovel = imovelService.adicionarImovel(valor, descricao, endereco, proprietario);
		return imovel != null ? "Imovel cadastrado com sucesso." : "Erro: Imovel já cadastrado";
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String deletarImovel(@PathVariable("endereco") String endereco) {
		return imovelService.deletarImovel(endereco);
	}
}

