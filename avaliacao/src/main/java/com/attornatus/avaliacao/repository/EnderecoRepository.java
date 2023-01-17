package com.attornatus.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.attornatus.avaliacao.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	
}
