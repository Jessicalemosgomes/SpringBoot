package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")

public class HelloController02 {
	
	@GetMapping()
	
	public String hello02() {
		String texto="<h1>Objetivos de aprendizagem da semana:</h1><br>"
				+ "<h1><ol>"
				+ "<li>Estudar mais sobre o protocolo HTTP </li>"
				+ "<li> Aprender mais sobre banco de dados com MySql</li>"
				+ "<li>Me aprofundar em Programação Orientada a Objetos </li>"
				+ "<li>Aprender Spring boot</li>"
				+ "<li>Melhorar habilidades comportamentais, como: Atenção aos detalhes, persistencia e proatividade</li>"
				+ "</ol></h1>";
		
		return texto;
	}
	
}
