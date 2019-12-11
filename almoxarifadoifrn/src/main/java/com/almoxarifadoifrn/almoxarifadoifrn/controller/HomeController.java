package com.almoxarifadoifrn.almoxarifadoifrn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String autenticacao() {
		return "Home/autenticacao";
	}
	
	@GetMapping("/homeADM")
	public String home() {
		return "Home/home";
	}
	
	@GetMapping("/home*")
	public String homeser() {
		return "Home/homeSER";
	}
	
	@GetMapping("/home")
	public String homepub() {
		return "Home/homePUB";
	}

}