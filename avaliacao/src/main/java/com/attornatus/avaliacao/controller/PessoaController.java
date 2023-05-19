package com.attornatus.avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.service.pessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="pessoas", description="Operações de controle de pessoas")
@RequestMapping("/")
public class PessoaController {
	
		@Autowired
		private pessoaService service;
		
		@ApiOperation(value = "Listar todas as pessoas", notes = "Retorna todas pessoas cadastradas")
		@GetMapping("pessoas")
		public List<Pessoa> findAll() {
			return service.getPessoas();
		}
		
		@ApiOperation(value = "Listar pessoa por id", notes = "Retorna uma pessoa pelo id especificado")
		@GetMapping("pessoas/{id}")
		public Optional<Pessoa> findById(@PathVariable long id){
		   return service.getPessoaPorId(id);
		}
		
		@ApiOperation(value = "Cadastrar nova pessoa", notes = "Cadastra uma nova pessoa")
		@PostMapping("pessoas")
		public Pessoa save(@RequestBody Pessoa pessoa) {
			return service.addPessoa(pessoa);
		}
		
		@ApiOperation(value = "Deletar pessoa", notes = "Deleta uma pessoa pelo id especificado")
		@DeleteMapping("pessoas/{id}")
		public void delete(@PathVariable long id) {
			service.deletePessoa(id);
		}
		
		@ApiOperation(value = "Atualizar pessoa", notes = "Atualiza dados da pessoa pelo id especificado")
		@PutMapping("pessoas/{id}")
		public Pessoa updatePessoa(@PathVariable long id, @RequestBody Pessoa pessoa) {
			return service.updatePessoa(id, pessoa);
					
		}
		
	
}

