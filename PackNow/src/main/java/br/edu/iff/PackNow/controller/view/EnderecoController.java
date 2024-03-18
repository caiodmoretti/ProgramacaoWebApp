package br.edu.iff.PackNow.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.PackNow.model.Endereco;
import br.edu.iff.PackNow.service.EnderecoService;

@Controller
@RequestMapping("endereco")
public class EnderecoController {
	@Autowired
	public EnderecoService endereceoServ;
	
	@GetMapping("/adicionar")
	public String addEnderecoForm(Model model){
		model.addAttribute("endereco", new Endereco());
		return "endereco/adicionar-endereco";
	}
	@PostMapping("/registrar")
	public String addEndereco(@ModelAttribute Endereco newEndereco, Model model) {
		endereceoServ.addEndereco(newEndereco);
		System.out.println("Adicionado: " + newEndereco.getId());
		model.addAttribute("endereco", new Endereco());
		model.addAttribute("message", "Endereço adicionado com sucesso.<br>Bloco: " + newEndereco.getBloco() +"<br>Número: " + newEndereco.getNumero());
		return "endereco/adicionar-endereco";
	}
	@GetMapping("/listar")
	public String listarEnderecos(Model model) {
		model.addAttribute("endereco_lista", endereceoServ.listarEnderecos());
		return "endereco/visualizar-enderecos";
	}
}
