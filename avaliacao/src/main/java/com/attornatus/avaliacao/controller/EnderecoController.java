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
import com.attornatus.avaliacao.service.enderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="endereços", description="Operações de controle de endereços")
@RequestMapping("/")
public class EnderecoController {
	
	@Autowired
	private enderecoService service;
	
	@ApiOperation(value = "Listar todos endereços", notes = "Retorna todos os endereços cadastrados")
	@GetMapping("enderecos")
	public List<Endereco> findAll(){
		return service.getEnderecos();
	}
	
	@ApiOperation(value = "Lista endereço por id", notes = "Retorna o endereço com o id especifico")
	@GetMapping("enderecos/{id}")
	public Optional<Endereco> findById(@PathVariable long id) {
		return service.getEnderecoPorId(id);
		
	}
	
	@ApiOperation(value = "Atualizar endereço", notes = "Atualiza endereço pelo id informado")
	@PutMapping("enderecos/{id}")
	public Endereco atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco) {
		return service.updateEndereco(id, endereco);
	}
	
	@ApiOperation(value = "Deletar endereço", notes = "Deleta o endereço pelo id informado")
	@DeleteMapping("enderecos/{id}")
	public void deletarEndereco(@PathVariable long id) {
		 service.deletarEndereco(id);
	}
	

}
