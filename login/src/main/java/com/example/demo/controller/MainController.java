package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.SessionRecorder;

@Controller
public class MainController {
	
	private final SessionRecorder sessionRecorder;
	
	public MainController(SessionRecorder sessionRecorder) {
		this.sessionRecorder = sessionRecorder;
	}

	@GetMapping("/main")
	public String viewMain(@RequestParam(required = false) String logout, Model model) {
		if(logout != null) {
			sessionRecorder.setNomeUsuario(null);
			return "redirect:/";
		}
		System.out.println(sessionRecorder.getNomeUsuario());
		model.addAttribute("message", sessionRecorder.getNomeUsuario());
		return "main.html";
	}
}
