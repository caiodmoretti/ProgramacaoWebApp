package br.edu.iff.PackNow.controller.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyViewControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String erroException(Exception e, Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
}
