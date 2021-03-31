package com.projeto.cidades.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto.cidades.projeto.modelo.Cidades;

public class CidadesDto {

	private Long id;
	private String nome;
	private String estado;

	public CidadesDto(Cidades cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();
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

	public static List<CidadesDto> converter(List<Cidades> cidade) {
		return cidade.stream().map(CidadesDto::new).collect(Collectors.toList());
	}

}
