package br.edu.iff.PackNow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "")
public class MainController {
	
	@GetMapping(path = "/home")
	@ResponseBody
	public String page1() {
		return "Esta é a Home.";
		
	}
}
