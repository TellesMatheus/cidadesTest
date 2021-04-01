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
class CidadesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testaCriacaoCidadeERetorna201() throws Exception {
		
		URI uri = new URI("/cidades/cadastrar");
		String json = "{\"nome\":\"Maravilha\",\"estado\":\"sc\"}";			
		PostERetorna201(uri, json);
		
	}
	
	@Test
	void testaBuscaCidadePeloNomeERetorna200() throws Exception {
		
		URI uri = new URI("/cidades/nome/Maravilha");
		String json = "{\"nome\":\"Maravilha\",\"estado\":\"sc\"}";	
		GetERetorna200(uri, json);
	}
	
	@Test
	void testaBuscaCidadePeloEstadoERetorna200() throws Exception {
		
		URI uri = new URI("/cidades/estado/sc");
		String json = "{\"nome\":\"Maravilha\",\"estado\":\"sc\"}";	
		GetERetorna200(uri, json);
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
}
