package com.projeto.cidades.projeto.controller.form;

import com.projeto.cidades.projeto.modelo.Cidades;

public class CidadesForm {

	private String nome;
	private String estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cidades converter() {
		return new Cidades(nome, estado);
	}

}
