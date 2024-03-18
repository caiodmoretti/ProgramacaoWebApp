package br.edu.iff.PackNow.controller.view;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.PackNow.model.Endereco;
import br.edu.iff.PackNow.model.Morador;
import br.edu.iff.PackNow.service.EnderecoService;
import br.edu.iff.PackNow.service.MoradorService;

@Controller
@RequestMapping("morador")
public class MoradorController {
	@Autowired
	public MoradorService moradorServ;
	@Autowired
	public EnderecoService enderecoServ;
	
	@GetMapping("/adicionar")
	public String addMoradorForm(Model model){
		model.addAttribute("morador", new Morador());
		model.addAttribute("endereco_lista", enderecoServ.listarEnderecos());
		model.addAttribute("bloco_lista", enderecoServ.listarBlocos());
		return "morador/adicionar-morador";
	}
    // Método para ajudar na exibição dos blocos
    @GetMapping("/buscarNumerosDoBloco")
    @ResponseBody
    public Set<String> buscarNumerosDoBloco(@RequestParam("bloco") String bloco) {
        return enderecoServ.listarNumerosDoBloco(bloco);
    }
	@PostMapping("/registrar")
	public String addMorador(@ModelAttribute Morador newMorador, Model model) {
		moradorServ.addMorador(newMorador);
		System.out.println("Adicionado: " + newMorador.getId());
		model.addAttribute("morador", new Morador());
		model.addAttribute("message", "Morador adicionado com sucesso.<br>Nome " + newMorador.getNome() +"<br>CPF: " + newMorador.getCpf()+ "<br>Endereço - Bloco " + newMorador.getEndereco().getBloco() + " Número " + newMorador.getEndereco().getNumero()); 
		return "success";
	}
	@GetMapping("/listar")
	public String listarMoradores(Model model) {
		model.addAttribute("morador_lista", moradorServ.listarMoradores());
		return "morador/visualizar-moradores";
	}
}
