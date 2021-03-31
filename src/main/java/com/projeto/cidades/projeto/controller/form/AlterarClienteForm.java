package com.projeto.cidades.projeto.controller.form;

import com.projeto.cidades.projeto.modelo.Cliente;
import com.projeto.cidades.projeto.repository.ClientesRepository;

public class AlterarClienteForm {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente alterar(Long id, ClientesRepository clientesRepository) {
		Cliente cliente = clientesRepository.getOne(id);
		cliente.setNome(nome);
		return cliente;
	}

}
