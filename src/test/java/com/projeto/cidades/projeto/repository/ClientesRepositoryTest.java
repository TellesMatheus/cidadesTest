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

import com.projeto.cidades.projeto.modelo.Cliente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ClientesRepositoryTest {

	@Autowired
	private ClientesRepository clientesRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void buscaPeloCliente() {
		String nomeCliente = "Matheus";
		
		Cliente Matheus = new Cliente();
		Matheus.setNome(nomeCliente);
		Matheus.setSexo("Masculino");
		Matheus.setDataNascimento(null);
		Matheus.setIdade((long) 19);
		Matheus.setCidade(cidadeRepository.findByNome("Maravilha"));
		em.persist(Matheus);
		
		Cliente cliente = clientesRepository.findByNome(nomeCliente);
		Assert.assertNotNull(cliente);
		Assert.assertEquals(nomeCliente, cliente.getNome());
	}
	
	@Test
	public void falhaBuscaPeloCliente() {
		String nomeCliente = "erro";
		Cliente cliente = clientesRepository.findByNome(nomeCliente);
		Assert.assertNull(cliente);
	}

}
