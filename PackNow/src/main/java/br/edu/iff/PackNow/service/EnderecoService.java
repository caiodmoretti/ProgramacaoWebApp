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
			EnderecoRep.flush();
			return "Endereço registrado no id " + e.getId();
		}
	}

	public String atualizarEndereco(Long id, String numero, String bloco) {
		Endereco e = EnderecoRep.buscarPeloId(id);
		if(e == null) {
			return("Endereço não encontrado");
		}else {
			if(numero == null || bloco == null) {
				throw new IllegalArgumentException("Entrada de dados não pode ser nula.");
			}
			e.setNumero(numero);
			e.setBloco(bloco);
			EnderecoRep.save(e);
			return "Informações do endereço com id "+e.getId()+ " foram atualizadas";
		}
	}

	public String deletarEntedereco(Long id) {
		Endereco e = EnderecoRep.buscarPeloId(id);
		if(e!=null) {	
			EnderecoRep.delete(e);
			return "Endereço com id "+ e.getId() + " foi deletado.";
		}else {
			return "Endereço não encontrado";
		}
	}
	public Endereco getEnderecoById(Long id) {
		if(EnderecoRep.buscarPeloId(id) == null){
			throw new IllegalArgumentException("Endereço com o id "+ id + " não foi encontrado.");
		}
		return EnderecoRep.buscarPeloId(id);
	}
	
	public Object getEnderecoByNumeroEBloco(String numero, String bloco) {
		if(EnderecoRep.buscarPeloNumeroEBloco(numero, bloco)== null) {
			throw new IllegalArgumentException("Endereço com o número "+ numero +" e bloco " + bloco +" não foi encontrado.");
		}
		return EnderecoRep.buscarPeloNumeroEBloco(numero, bloco);
	}
	public List<Endereco> listarEnderecos() {
		return EnderecoRep.findAll();
	}

}
