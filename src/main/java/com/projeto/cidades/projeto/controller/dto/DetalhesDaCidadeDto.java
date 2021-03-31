package com.projeto.cidades.projeto.controller.dto;

import com.projeto.cidades.projeto.modelo.Cidades;

public class DetalhesDaCidadeDto {

	private Long id;
	private String nome;
	private String estado;

	public DetalhesDaCidadeDto(Cidades cidades) {
		this.id = cidades.getId();
		this.nome = cidades.getNome();
		this.estado = cidades.getEstado();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEstado() {
		return estado;
	}

}
