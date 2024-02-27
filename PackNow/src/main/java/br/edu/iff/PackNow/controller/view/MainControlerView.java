package br.edu.iff.PackNow.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "crud")
public class MainControlerView {
	@GetMapping("/")
	public String cruds(){
		return "layoutBase";
	}
}
