package br.edu.iff.PackNow.controller.apirest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/encomenda")
public class EncomendaRestController {
	@Autowired
	public EncomendaService EncomendaServ;
	
	@PostMapping("")
	@ResponseBody
	@Operation(summary = "Adicionar uma encomenda")
	public String addEncomenda(Date dataEntrada, String nomeEntregador, String telefoneEntregador, Endereco enderecoEntrega) throws Exception{
		return EncomendaService.addEncomenda(new Encomenda(dataEntrada, nomeEntregador, telefoneEntregador, enderecoEntrega));
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Atualizar uma encomenda")
	public String atualizarEncomenda(@PathVariable("id") int id, Date dataEntrada, String nomeEntregador, String telefoneEntregador, Endereco enderecoEntrega) throws Exception{
		Encomenda eBusca = EncomendaServ.getEncomendaById(id);
		if(eBusca == null) {
			return "Encomenda não encontrado";
		} else {
			return EncomendaServ.atualizarEncomenda(eBusca.getEncomenda());
		}
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Deletar uma encomenda")
	public String deletarEncomenda(@PathVariable("id") int id) throws Exception {
		Encomenda eBusca = EncomendaServ.getEncomendaById(id);
		if(eBusca==null) {			
			return "Encomenda não encontrado";
		}else {
			return EncomendaServ.deletarEncomenda(eBusca.getEncomenda());
		}
	}
	@GetMapping("")
	@ResponseBody
	@Operation(summary = "Listar todas as encomendas")
	public List<Encomenda> listarEncomendas() throws Exception {
		return EncomendaServ.listarEncomendas();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Retornar uma encomenda")
	public Encomenda buscarEncomendaId(@PathVariable("id") Long id) throws Exception {
		return EncomendaServ.getEncomendaById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	@Operation(summary = "Registrar saida de uma encomenda")
	public String registrarSaidaEncomenda(@PathVariable("id")  Date dataSaida, String morador) throws Exception{
		Encomenda eBusca = EncomendaServ.getEncomendaById(id);
		if(eBusca == null) {
			return "Encomenda não encontrado";
		} else {
			return EncomendaServ.registrarSaidaEncomenda(eBusca.getEncomenda());
		}
	}
}
