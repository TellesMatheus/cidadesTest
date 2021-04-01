package com.projeto.cidades.projeto.controller;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ClientesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testaCriacaoClienteERetorna201() throws Exception {
		
		URI uri = new URI("/clientes/cadastrar");
		
		String json = "{\"nome\":\"Matheus\",\"sexo\":\"Masculino\",\"dataNascimento\":\"21/08/2001\",\"idade\":\"19\",\"cidade\":\"null\"}";			
		 PostERetorna201(uri, json);
		
		String json2 = "{\"nome\":\"TestaAtualizar\",\"sexo\":\"Masculino\",\"dataNascimento\":\"21/08/2001\",\"idade\":\"19\",\"cidade\":\"null\"}";
		PostERetorna201(uri, json2);
		
		String json3 = "{\"nome\":\"TestaDeletar\",\"sexo\":\"Masculino\",\"dataNascimento\":\"21/08/2001\",\"idade\":\"19\",\"cidade\":\"null\"}";
		PostERetorna201(uri, json3);
	}

	@Test
	void testaDeletaClientePeloIdERetorna200() throws Exception {
		
		URI uri = new URI("/clientes/3");
		String json = "{\"nome\":\"TestaDeletar\",\"sexo\":\"Masculino\",\"dataNascimento\":\"null\",\"idade\":\"19\",\"cidade\":\"null\"}";	
		DeletaERetorna200(uri, json);
	}
	
	@Test
	void testaBuscaClientePeloNomeERetorna200() throws Exception {
		
		URI uri = new URI("/clientes/nome/Matheus");
		String json = "{\"nome\":\"Matheus\",\"sexo\":\"Masculino\",\"dataNascimento\":\"null\",\"idade\":\"19\",\"cidade\":\"null\"}";
		GetERetorna200(uri, json);
	}
	
	@Test
	void testaBuscaClientePeloIdERetorna200() throws Exception {
		
		URI uri = new URI("/clientes/id/1");
		String json = "{\"nome\":\"Matheus\",\"sexo\":\"Masculino\",\"dataNascimento\":\"null\",\"idade\":\"19\",\"cidade\":\"null\"}";
		GetERetorna200(uri, json);
	}
	
	@Test
	void testaAtualizaClientePeloIdERetorna200() throws Exception {
		
		URI uri = new URI("/clientes/2");
		String json = "{\"nome\":\"TestaAtualizar\",\"sexo\":\"Masculino\",\"dataNascimento\":\"null\",\"idade\":\"19\",\"cidade\":\"null\"}";
		AtualizaERetorna200(uri, json);
	
	}
	
	public void PostERetorna201(URI uri, String json) throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
	}
	
	public void GetERetorna200(URI uri, String json) throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	public void DeletaERetorna200(URI uri, String json) throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	public void AtualizaERetorna200(URI uri, String json) throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
}
