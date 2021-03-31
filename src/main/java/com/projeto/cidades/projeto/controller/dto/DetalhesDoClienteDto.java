package com.projeto.cidades.projeto.controller.dto;

import java.time.LocalDate;

import com.projeto.cidades.projeto.modelo.Cliente;

public class DetalhesDoClienteDto {

	private Long id;
	private String nome;
	private String sexo;
	private LocalDate dataNascimento;
	private Long idade;

	public DetalhesDoClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.idade = cliente.getIdade();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Long getIdade() {
		return idade;
	}

}
