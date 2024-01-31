package br.edu.iff.PackNow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.PackNow.model.Endereco;
import br.edu.iff.PackNow.model.Morador;
import br.edu.iff.PackNow.repository.EnderecoRepository;
import br.edu.iff.PackNow.repository.MoradorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Service
public class MoradorService {

	@Autowired
	private MoradorRepository MoradorRep;	
	
	@Autowired
	private EnderecoRepository EnderecoRep;	
	
	
	public String addMorador(Morador morador) {
		if(MoradorRep.buscarPeloCPF(morador.getCpf())!=null) {
			return "Morador já cadastrado.";
		}else {
			Morador m = MoradorRep.save(morador);
			return "Morador registrado no id " + m.getId();
		}
	}
	
	public String deletarMoradorCPF(String cpf) {
		Morador m = MoradorRep.buscarPeloCPF(cpf);
		if(m!=null) {	
			MoradorRep.delete(m);
			return "Morador com id "+m.getId() + " foi deletado.";
		}else {
			return "Morador não encontrado";
		}
	}

	public List<Morador> listarMoradores() {
		return MoradorRep.findAll();
	}

    @Transactional
	public String adicionarMoradorNoEndereco(Long id, Long enderecoId) {
		Morador m = MoradorRep.buscarPeloId(id);
		Endereco e = EnderecoRep.buscarPeloId(enderecoId);
		if(m == null || e == null) {
			return "Morador ou endereço não encontrado";
		}
			m.adicionarMoradorNoEndereco(e);	
			MoradorRep.save(m);
			return "Morador do id " + m.getId() +" foi adicionado no endereço.";
	}
    @Transactional
    public String atualizarDadosMorador(Long id, String nome, String telefone, String cpf) {
		Morador m = MoradorRep.buscarPeloId(id);
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
			MoradorRep.save(m);
		return "Dados do morador com id " + m.getId() +" foram atualizado.";
		}
    }
    
	public Morador getMoradorById(Long id) {
		return MoradorRep.buscarPeloId(id);
	}
	
	public Morador getMoradorByCPF(String cpf) {
		return MoradorRep.buscarPeloCPF(cpf);
	}

}
