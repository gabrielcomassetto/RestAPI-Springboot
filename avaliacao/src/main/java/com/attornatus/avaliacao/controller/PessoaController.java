package com.attornatus.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.avaliacao.model.Endereco;
import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.PessoaRepository;

@RestController
@RequestMapping("/")
public class PessoaController {
	
		@Autowired
		private PessoaRepository repository;
		
	
		@GetMapping(path = {"pessoas"})
		public List<Pessoa> findAll() {
			return repository.findAll();		
		}
		
		
		@GetMapping(path = {"pessoas/{id}"})
		public ResponseEntity<?> findById(@PathVariable long id){
		   return repository.findById(id)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
		}
		
		
		@PostMapping
		public Pessoa save(@RequestBody Pessoa pessoa) {
			return repository.save(pessoa);
		}
		
		@DeleteMapping(path ={"pessoas/{id}"})
		public ResponseEntity <?> delete(@PathVariable long id) {
		   return repository.findById(id)
		           .map(record -> {
		               repository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}
		
		@PostMapping
		public ResponseEntity<Object> addEndereco(@PathVariable long id, Endereco endereco){
			return repository.findById(id).map(record -> {
			repository.(endereco);
			return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());

			
		}
			
		
		
		
		

}

