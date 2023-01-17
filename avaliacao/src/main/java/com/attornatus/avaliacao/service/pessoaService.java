package com.attornatus.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.PessoaRepository;

@Service
public class pessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public List<Pessoa> getPessoas() {
		return repository.findAll();
	}
	
	public Optional<Pessoa> getPessoaPorId(long id) {
		return repository.findById(id);
	}
	
	public Pessoa addPessoa(Pessoa pessoa) {
		return repository.save(pessoa);
		
	}
	
	public Pessoa updatePessoa(long id, Pessoa pessoa) {
		pessoa.setId(id);
		return repository.save(pessoa);
	}
	
	public void deletePessoa(long id) {
		 repository.deleteById(id);
	}
}
