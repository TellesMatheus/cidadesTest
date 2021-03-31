package com.projeto.cidades.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.cidades.projeto.modelo.Cidades;

public interface CidadeRepository extends JpaRepository<Cidades, Long> {

	Cidades findByNome(String nome);

	Optional<Cidades> findByEstado(String estado);

}
