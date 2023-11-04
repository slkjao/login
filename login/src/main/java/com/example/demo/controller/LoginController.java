package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginValidator;
import com.example.demo.service.SessionRecorder;

@Controller
public class LoginController {
	
	private final LoginValidator loginValidator;
	private final SessionRecorder sessionRecorder;
	
	public LoginController(LoginValidator loginValidator, SessionRecorder sessionRecorder) {
		this.loginValidator = loginValidator;
		this.sessionRecorder = sessionRecorder;
	}

	@GetMapping("/")
	public String viewLogin() {
		return "login.html";
	}
	
	@PostMapping("/")
	public String postLogin(Model model, @RequestParam String user, @RequestParam String password) {
		loginValidator.setUser(user);
		loginValidator.setPassword(password);
		boolean resposta = loginValidator.isValid();
		if(resposta) {
			sessionRecorder.setNomeUsuario(user);
			return "redirect:/main";
		} else {			
			model.addAttribute("message", "erroooouuuuuu");
		}
		return "login.html";		
	}
}
