package br.edu.iff.PackNow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.PackNow.model.Morador;
import br.edu.iff.PackNow.repository.MoradorRepository;
@Service
public class MoradorService {

	@Autowired
	private MoradorRepository MoradorRep;
	
	public String addMorador(Morador morador) {
		if(MoradorRep.buscarPeloCPF(morador.getCpf())!=null) {
			return "Morador já cadastrado.";
		}else {
			Morador m = MoradorRep.save(morador);
			return "Morador registrado no id " + m.getId();
		}
	}

	public Morador getMoradorById(Long id) {
		return MoradorRep.buscarPeloId(id);
	}
	
	public Morador getMoradorByCPF(String cpf) {
		return MoradorRep.buscarPeloCPF(cpf);
	}

	public String deletarMoradorCPF(String cpf) {
		Morador m = MoradorRep.buscarPeloCPF(cpf);
		if(m!=null) {	
			MoradorRep.delete(m);
			return "Morador deletado no id "+m.getId();
		}else {
			return "Morador não encontrado";
		}
	}

	public List<Morador> listarMoradores() {
		return MoradorRep.findAll();
	}

	public String atualizarMorador(String nome, String telefone, String cpf) {
		Morador m = MoradorRep.buscarPeloCPF(cpf);
		if(m==null) {
			return "Morador não encontrado";
		}else {
			if(nome!=null) {
				m.setNome(nome);
			}
			if(telefone!=null) {
				m.setTelefone(telefone);
			}
			if(cpf!=null) {
				m.setCpf(cpf);
			}

			return "Atualizado no id "+m.getId();
		}
	}

}
