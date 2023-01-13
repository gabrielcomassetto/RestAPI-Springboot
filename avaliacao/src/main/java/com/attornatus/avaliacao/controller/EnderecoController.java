package com.attornatus.avaliacao.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.attornatus.avaliacao.model.Endereco;
import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.EnderecoRepository;
import com.attornatus.avaliacao.repository.PessoaRepository;

@RestController
@RequestMapping("/")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	private PessoaRepository pessoaRepository;
	
	
	
	@GetMapping
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}
	
	@PostMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable long id, Pessoa pessoa ){
		Endereco endereco = enderecoRepository.findById(null)
	}
	    		pessoaRepository.findById(id);
	    		
	   
	

}
