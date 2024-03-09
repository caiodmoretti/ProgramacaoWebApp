package br.edu.iff.PackNow.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "")
public class MainControllerView {
	@GetMapping("/")
	public String cruds(){
		return "layoutBase";
	}
	@GetMapping("/pagina1")
	public String teste(){
		return "pagina1";
	}
}
