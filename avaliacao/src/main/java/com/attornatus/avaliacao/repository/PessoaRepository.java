package com.attornatus.avaliacao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.attornatus.avaliacao.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query("select P.nome, E.cep, E.cidade, E.logradouro, E.numero from Pessoa P inner join Endereco E on P.id = E.id where P.id = ?1")
	List<String> findEnderecoPessoaById(Long id);
	
			
}
