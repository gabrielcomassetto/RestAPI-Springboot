package com.attornatus.avaliacao.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.PessoaRepository;

@ExtendWith(MockitoExtension.class)
public class pessoaServiceTest {
	
	@InjectMocks
	private pessoaService service;
	
	@Mock
	private PessoaRepository repository;
	
	@Test
	@DisplayName("Deve criar nova pessoa")
	void ShouldCreateNewPerson() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Gabriel");
		pessoa.setDataNasc("30/03/1995");
		
		service.addPessoa(pessoa);
		
		Mockito.verify(repository, times(1)).save(pessoa);
		
		
	}
	
	@Test
	@DisplayName("Deve buscar pessoas pelo id")
	void ShouldFindPersons() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Gabriel");
		
		service.getPessoaPorId(1);

		Mockito.verify(repository, times(1)).findById(1L);
		
	}
	
	@Test
	@DisplayName("Deve buscar todas as pessoas")
	void ShouldFindAllPersons(){
		List<Pessoa> pessoaslist = Arrays.asList(
				new Pessoa(1L, "Gabriel", null, null),
				new Pessoa(2L, "Amanda", null, null)
				);
		
		when(repository.findAll()).thenReturn(pessoaslist);
		
		List<Pessoa> pessoas = service.getPessoas();

		
		Mockito.verify(repository, times(1)).findAll();
		
	}
	
	@Test
	@DisplayName("Deve atualizat pessoa pelo id")
	void ShouldUpdatePerson() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		
		service.updatePessoa(1, pessoa);
		
		Mockito.verify(repository, times(1)).save(pessoa);
				
	}
	
	@Test
	@DisplayName("Deve deletar pessoa pelo id")

	void ShouldDeletePersonByid() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		
		service.deletePessoa(1);
		
		Mockito.verify(repository, times(1)).deleteById((long) 1);
		
	}
}
