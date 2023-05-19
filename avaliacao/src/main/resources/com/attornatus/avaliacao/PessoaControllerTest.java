package com.attornatus.avaliacao;



import com.attornatus.avaliacao.controller.PessoaController;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {
	
	@InjectedMocks
	private PessoaController pessoaController;
	
	@Mock
	private pessoaService PessoaService;
	
	private Pessoa pessoa;
	
	
	@BeforeEach
	void setup() {
		pessoa = new Pessoa(nome = "Gabriel", dataNasc = "30/03/1995");
	}
	
	@Test
	void deveSalvarNovaPessoa() {
		pessoaController.save(pessoa)
	}

}
