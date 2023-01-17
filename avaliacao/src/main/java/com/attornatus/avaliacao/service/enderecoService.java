package com.attornatus.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.avaliacao.model.Endereco;
import com.attornatus.avaliacao.repository.EnderecoRepository;

@Service
public class enderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> getEnderecos(){
		return repository.findAll();
	}
	
	public Optional<Endereco> getEnderecoPorId(Long id) {
		return repository.findById(id);
	}
	
	public Endereco updateEndereco(long id, Endereco endereco) {
		endereco.setId(id);
		return repository.save(endereco);
	}
	
	public void deletarEndereco(long id) {
		repository.deleteById(id);
	}

	
}
