package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/softSkills")
public class HelloController {

	@GetMapping
	public String hello()
	{
		String texto = "<h1> Para realizar esta atividade eu utilizei a habilidade de atencao aos detalhes"
	+"<br>E a mentalidade utilizada foi a persistencia</h1>";
		
		return texto;
	}
}
