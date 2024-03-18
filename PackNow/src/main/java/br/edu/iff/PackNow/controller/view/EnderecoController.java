package br.edu.iff.PackNow.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.PackNow.model.Endereco;
import br.edu.iff.PackNow.service.EnderecoService;
import io.micrometer.core.ipc.http.HttpSender.Request;

@Controller
@RequestMapping("endereco")
public class EnderecoController {
	@Autowired
	public EnderecoService enderecoServ;
	
	@GetMapping("/adicionar")
	public String addEnderecoForm(Model model){
		model.addAttribute("endereco", new Endereco());
		return "endereco/adicionar-endereco";
	}
	@PostMapping("/registrar")
	public String addEndereco(@ModelAttribute Endereco newEndereco, Model model) {
		enderecoServ.addEndereco(newEndereco);
		System.out.println("Adicionado: " + newEndereco.getId());
		model.addAttribute("endereco", new Endereco());
		model.addAttribute("message", "Endereço adicionado com sucesso.<br>Bloco: " + newEndereco.getBloco() +"<br>Número: " + newEndereco.getNumero());
		return "endereco/adicionar-endereco";
	}
	@GetMapping("/listar")
	public String listarEnderecos(Model model) {
		model.addAttribute("endereco_lista", enderecoServ.listarEnderecos());
		return "endereco/visualizar-enderecos";
	}
	@GetMapping("/edit/{id}")
	public String showUpdateEnderecoForm(@PathVariable("id") Long id, Model model) {
	    Endereco endereco = enderecoServ.getEnderecoById(id);
	    model.addAttribute("endereco", endereco);
	    return "endereco/editar-endereco";
	}
	@PostMapping( "/update/{id}")
	public String updateEndereco(@PathVariable("id") Long id, Endereco endereco, Model model) {
		String bloco = endereco.getBloco();
		String numero = endereco.getNumero();
		enderecoServ.atualizarEndereco(id, numero, bloco);
		model.addAttribute("message", "Endereço atualizado com sucesso.<br>Bloco: " + endereco.getBloco() +"<br>Número: " + endereco.getNumero());
		return "success";
	}
	@GetMapping("/delete/{id}")
	public String deleteEndereco(@PathVariable("id") Long id, Model model) {
	    enderecoServ.deletarEndereco(id);
	    model.addAttribute("message", "Endereço deletado com sucesso.");
	    return "success";
	}

	
	
	/*
	@GetMapping("/editar/{id}")
	public String editarEnderecoForm(@PathVariable Long id, Model model) {
	    Endereco endereco = endereceoServ.getEnderecoById(id);
	    model.addAttribute("endereco_edit", endereco);
	    return "endereco/editar-endereco";
	}

	@PostMapping("/atualizar")
	public String editarEndereco(@ModelAttribute Endereco endereco, Model model) {
	    String bloco = endereco.getBloco();
	    String numero = endereco.getNumero();
	    endereceoServ.atualizarEndereco(bloco, numero);
	    model.addAttribute("message", "Endereço atualizado com sucesso.<br>Bloco: " + endereco.getBloco() +"<br>Número: " + endereco.getNumero());
	    return "success";
	}*/
}
