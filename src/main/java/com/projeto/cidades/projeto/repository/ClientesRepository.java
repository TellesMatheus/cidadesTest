package com.projeto.cidades.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cidades.projeto.modelo.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {
	Cliente findByNome(String nome);

	List<Cliente> findByCidadeNome(String nomeCidade);

}
