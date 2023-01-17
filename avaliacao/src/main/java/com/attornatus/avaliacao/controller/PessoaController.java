package com.attornatus.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.avaliacao.model.Endereco;
import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.EnderecoRepository;
import com.attornatus.avaliacao.repository.PessoaRepository;
import com.attornatus.avaliacao.service.pessoaService;

@RestController
@RequestMapping("/")
public class PessoaController {
	
		@Autowired
		private pessoaService service;
		
	
		@GetMapping("pessoas")
		public List<Pessoa> findAll() {
			return service.getPessoas();
		}
		
		
		@GetMapping("pessoas/{id}")
		public Optional<Pessoa> findById(@PathVariable long id){
		   return service.getPessoaPorId(id);
		}
		
		
		@PostMapping("pessoas")
		public Pessoa save(@RequestBody Pessoa pessoa) {
			return service.addPessoa(pessoa);
		}
		
		@DeleteMapping("pessoas/{id}")
		public void delete(@PathVariable long id) {
			service.deletePessoa(id);
		}
		
		@PutMapping("pessoas/{id}")
		public Pessoa updatePessoa(@PathVariable long id, @RequestBody Pessoa pessoa) {
			return service.updatePessoa(id, pessoa);
					
		}

	
		
		

}

