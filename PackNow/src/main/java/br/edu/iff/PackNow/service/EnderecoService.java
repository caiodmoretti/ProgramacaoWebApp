package br.edu.iff.PackNow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.PackNow.model.Endereco;

import br.edu.iff.PackNow.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository EnderecoRep;
	
	public String addEndereco(Endereco endereco) {
		if(EnderecoRep.buscarPeloNumeroEBloco(endereco.getNumero(), endereco.getBloco()) != null) {
			return "Endereço já foi cadastrado.";
		}else {
			Endereco e = EnderecoRep.save(endereco);
			return "Endereço registrado no id " + e.getId();
		}
	}

	public Endereco getEnderecoById(Long id) {
		return EnderecoRep.buscarPeloId(id);
	}
	public Object getEnderecoByNumeroEBloco(String numero, String bloco) {
		return EnderecoRep.buscarPeloNumeroEBloco(numero, bloco);
	}
	public List<Endereco> listarEnderecos() {
		return EnderecoRep.findAll();
	}

	public String atualizarEndereco(String numero, String bloco) {
		Endereco e = EnderecoRep.buscarPeloNumeroEBloco(numero, bloco);
		if(e == null) {
			return("Endereço não encontrado");
		}else {
			if(numero != null && bloco != null) {
				e.setNumero(numero);
				e.setBloco(bloco);
			}
			return "Atualizado no id "+e.getId();
		}
	}


	public String deletarEntedereco(String numero, String bloco) {
		Endereco e = EnderecoRep.buscarPeloNumeroEBloco(numero, bloco);
		if(e!=null) {	
			EnderecoRep.delete(e);
			return "Endereço deletado no id "+e.getId();
		}else {
			return "Endereço não encontrado";
		}
	}

}
