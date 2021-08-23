package com.spring.lista1.aplication.controller;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController 
public class Lista1Controller { 
	
	@GetMapping ("/atividade1") 
	public String mostrarAtividade1 () { 
		
		return "A habilidade que eu mais usei nessa atividade foi a atenção aos detalhes!!"; 
	} 
	
	@GetMapping ("/atividade2") 
	
	public String mostrarAtividade2 () {
		
		return "A habilidade que eu mais preciso melhorar nessa semana é a atenção aos detalhes e comunicação!!"; 
	} 
}