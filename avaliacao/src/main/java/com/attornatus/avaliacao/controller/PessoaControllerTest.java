package com.attornatus.avaliacao.controller;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.attornatus.avaliacao.model.Pessoa;
import com.attornatus.avaliacao.repository.PessoaRepository;
import com.attornatus.avaliacao.service.pessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class PessoaControllerTest {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PessoaRepository repository;
	

	
	@BeforeEach
	void up() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Gabriel");
		pessoa.setDataNasc("1995/03/11");
		pessoa.setEnderecos(null);
		repository.save(pessoa);
	}
	
	@AfterEach
	void down() {
		repository.deleteAll();
	}
	

	@Test
	@DisplayName("Listar todas pessoas")
	void listaPessoas() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/pessoas"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
		
	}
	

	@Test
	@DisplayName("Listar pessoa pelo id")
	void listaPessoaPorId() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("/pessoas/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
		
	}
	

	@Test
	@DisplayName("Salvar nova pessoa")
	void salvarPessoa() throws Exception{
	
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Joao");
		pessoa.setId(1L);
		pessoa.setDataNasc("11/01/1993");
		
		String pessoareq = mapper.writeValueAsString(pessoa);
		
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas")
		.contentType(MediaType.APPLICATION_JSON)
		.content(pessoareq))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
	
	

	@Test
	@DisplayName("Atualizar pessoa")
	void atualizarPessoa() throws Exception{
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Helena");
		pessoa.setDataNasc("27/11/1990");
		pessoa.setId(1L);
		
		String pessoareq = mapper.writeValueAsString(pessoa);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/pessoas/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(pessoareq))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
		
	}
	

	@Test
	@DisplayName("Deletar pessoa por id")
	void deletarPessoaPorId() throws Exception{
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
	
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/pessoas/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
			
	}
}
