package com.attornatus.avaliacao.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.attornatus.avaliacao.model.Endereco;
import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.EnderecoRepository;
import com.attornatus.avaliacao.service.enderecoService;


@RestController
@RequestMapping("/")
public class EnderecoController {
	
	@Autowired
	private enderecoService service;
	
	
	@GetMapping("enderecos")
	public List<Endereco> findAll(){
		return service.getEnderecos();
	}
	
	@GetMapping("enderecos/{id}")
	public Optional<Endereco> findById(@PathVariable long id) {
		return service.getEnderecoPorId(id);
		
	}
	
	@PutMapping("enderecos/{id}")
	public Endereco atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco) {
		return service.updateEndereco(id, endereco);
	}
	
	@DeleteMapping("enderecos/{id}")
	public void deletarEndereco(@PathVariable long id) {
		 service.deletarEndereco(id);
	}

}
