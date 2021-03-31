package com.projeto.cidades.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.cidades.projeto.controller.dto.ClienteDto;
import com.projeto.cidades.projeto.controller.dto.DetalhesDoClienteDto;
import com.projeto.cidades.projeto.controller.form.AlterarClienteForm;
import com.projeto.cidades.projeto.controller.form.ClienteForm;
import com.projeto.cidades.projeto.modelo.Cliente;
import com.projeto.cidades.projeto.repository.CidadeRepository;
import com.projeto.cidades.projeto.repository.ClientesRepository;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping("/listar")
	public List<ClienteDto> listar(@RequestParam(required = false) String nomeCidade) {
		List<Cliente> cliente = clientesRepository.findAll();
		return ClienteDto.converter(cliente);
	}

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm form,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter(cidadeRepository);
		clientesRepository.save(cliente);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<DetalhesDoClienteDto> consultaClientePeloNome(@PathVariable String nome) {
		Optional<Cliente> cliente = Optional.of(clientesRepository.findByNome(nome));

		if (cliente.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoClienteDto(cliente.get()));
		}
		return ResponseEntity.notFound().build();

	}

	@GetMapping("/id/{id}")
	public ResponseEntity<DetalhesDoClienteDto> consultaClientePeloId(@PathVariable Long id) {
		Optional<Cliente> cliente = clientesRepository.findById(id);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoClienteDto(cliente.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Cliente> cliente = clientesRepository.findById(id);
		if (cliente.isPresent()) {
			clientesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid AlterarClienteForm form) {
		Optional<Cliente> cliente = clientesRepository.findById(id);
		if (cliente.isPresent()) {
			Cliente novoCliente = form.alterar(id, clientesRepository);
			return ResponseEntity.ok(new ClienteDto(novoCliente));
		}
		return ResponseEntity.notFound().build();
	}

}
