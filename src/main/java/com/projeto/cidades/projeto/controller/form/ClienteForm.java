package com.projeto.cidades.projeto.controller.form;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.projeto.cidades.projeto.modelo.Cidades;
import com.projeto.cidades.projeto.modelo.Cliente;
import com.projeto.cidades.projeto.repository.CidadeRepository;

public class ClienteForm {

	private String nome;
	private String sexo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private Long idade;
	private String cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Cliente converter(CidadeRepository cidadeRepository) {
		Cidades cidades = cidadeRepository.findByNome(cidade);
		return new Cliente(nome, sexo, dataNascimento, idade, cidades);
	}

}
