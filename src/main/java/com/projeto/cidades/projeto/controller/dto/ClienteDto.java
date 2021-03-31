package com.projeto.cidades.projeto.controller.dto;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

import com.projeto.cidades.projeto.modelo.Cidades;
import com.projeto.cidades.projeto.modelo.Cliente;

public class ClienteDto {

	private Long id;
	private String nome;
	private String sexo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private Long idade;
	private Cidades cidades;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.idade = cliente.getIdade();
		this.cidades = cliente.getCidade();
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

	public Cidades getCidade() {
		return cidades;
	}

	public static List<ClienteDto> converter(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}

}
