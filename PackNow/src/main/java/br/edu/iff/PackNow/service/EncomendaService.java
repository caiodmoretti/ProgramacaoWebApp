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
import br.edu.iff.PackNow.repository.EnderecoRepository;
import br.edu.iff.PackNow.repository.FuncionarioRepository;
import br.edu.iff.PackNow.repository.MoradorRepository;
import jakarta.transaction.Transactional;
@Service
public class EncomendaService {
	@Autowired
	private EncomendaRepository EncomendaRep;
	
	@Autowired
	private MoradorRepository MoradorRep;
	
	@Autowired
	private FuncionarioRepository FuncionarioRep;
	
	@Autowired
	private EnderecoRepository EnderecoRep;



	
	public String addEncomenda(Long funcionarioId, Long enderecoId, String nomeEntregador, String telefoneEntregador) {
		Funcionario f = FuncionarioRep.buscarPeloId(funcionarioId);
		Endereco endereco = EnderecoRep.buscarPeloId(enderecoId);
		Encomenda e = new Encomenda(f, endereco, nomeEntregador,telefoneEntregador);
		EncomendaRep.save(e);
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
	
	public String atualizarEncomenda(Long id, Funcionario funcionarioEntrada, Endereco enderecoEntrega, Morador moradorRetirada, String dataEntrada, String dataSaida, String nomeEntregador, String telefoneEntregador ) {
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
			EncomendaRep.save(e);
			return "Encomenda com o id "+e.getId() + " foi atualizada.";
		}
	}

	public String registrarSaida(Long id, Long idMorador) {
		Morador m = MoradorRep.buscarPeloId(idMorador);
		Encomenda e = EncomendaRep.buscarPeloId(id);
		if(e==null) {
			return "Encomenda não encontrada.";
		}else {
			if(m!=null) {
				e.setMoradorRetirada(m);
				e.setDataSaida(e.obterHoraEmFormatoString());
				EncomendaRep.save(e);
				return "A saída da encomenda com o id "+e.getId() + " foi registrada.";
			}
		}
		return "Dados inválidos para a retirada da encomenda.";
	}

}
