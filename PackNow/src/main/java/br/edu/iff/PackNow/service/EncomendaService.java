package br.edu.iff.PackNow.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.PackNow.model.Encomenda;
import br.edu.iff.PackNow.model.Endereco;
import br.edu.iff.PackNow.model.Funcionario;
import br.edu.iff.PackNow.model.Morador;
import br.edu.iff.PackNow.repository.EncomendaRepository;
@Service
public class EncomendaService {
	@Autowired
	private EncomendaRepository EncomendaRep;
	
	public String addEncomenda(Encomenda encomenda) {
		Encomenda e = EncomendaRep.save(encomenda);
		return "Encomenda registrada no id " + e.getId();
	}

	public Encomenda getEncomendaById(Long id) {
		return EncomendaRep.buscarPeloId(id);
	}

	public List<Encomenda> listarEncomendas() {
		return EncomendaRep.findAll();
	}
	
	public String deletarEncomendaPorId(Long id) {
		Encomenda e = EncomendaRep.buscarPeloId(id);
		if(e!=null) {	
			EncomendaRep.delete(e);
			return "Encomenda deletada no id "+e.getId();
		}else {
			return "Encomenda não encontrada.";
		}
	}
	
	public String atualizarEncomenda(Long id, Funcionario funcionarioEntrada, Morador moradorRetirada, Endereco enderecoEntrega, LocalDate dataEntrada, LocalDate dataSaida, String nomeEntregador, String telefoneEntregador ) {
		Encomenda e = EncomendaRep.buscarPeloId(id);
		if(e==null) {
			return "Encomenda não encontrada.";
		}else {
			if(funcionarioEntrada!=null) {
				e.setFuncionario(funcionarioEntrada);;
			}
			if(moradorRetirada!=null) {
				e.setMoradorRetirada(moradorRetirada);;
			}
			if(enderecoEntrega!=null) {
				e.setEndereco(enderecoEntrega);
			}
			if(dataEntrada!=null) {
				e.setDataEntrada(dataEntrada);
			}
			if(dataSaida!=null) {
				e.setDataEntrada(dataSaida);
			}
			if(nomeEntregador!=null) {
				e.setNomeEntregador(nomeEntregador);
			}
			if(telefoneEntregador!=null) {
				e.setTelefoneEntregador(telefoneEntregador);
			}
			return "Encomenda atualizada no id "+e.getId();
		}
	}

}
