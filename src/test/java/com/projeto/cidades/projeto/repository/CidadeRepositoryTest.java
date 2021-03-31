package com.projeto.cidades.projeto.repository;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.projeto.cidades.projeto.modelo.Cidades;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CidadeRepositoryTest {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void buscaPelaCidade() {
		String nomeCidade = "Maravilha";
		
		Cidades Maravilha = new Cidades();
		Maravilha.setNome(nomeCidade);
		Maravilha.setEstado("SC");
		em.persist(Maravilha);
		
		Cidades cidades = cidadeRepository.findByNome(nomeCidade);
		Assert.assertNotNull(cidades);
		Assert.assertEquals(nomeCidade, cidades.getNome());
	}
	
	@Test
	public void falhaBuscaPelaCidade() {
		String nomeCidade = "erro";
		Cidades cidades = cidadeRepository.findByNome(nomeCidade);
		Assert.assertNull(cidades);
	}
	
}
