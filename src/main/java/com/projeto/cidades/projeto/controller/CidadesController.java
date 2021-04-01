package com.projeto.cidades.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.cidades.projeto.controller.dto.CidadesDto;
import com.projeto.cidades.projeto.controller.dto.DetalhesDaCidadeDto;
import com.projeto.cidades.projeto.controller.form.CidadesForm;
import com.projeto.cidades.projeto.modelo.Cidades;
import com.projeto.cidades.projeto.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
@Profile(value = {"dev", "test"})
public class CidadesController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping("/listar")
	public List<CidadesDto> listar(@RequestParam(required = false) String nomeCidade) {
		List<Cidades> cidades = cidadeRepository.findAll();
		return CidadesDto.converter(cidades);
	}

	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<CidadesDto> cadastrarCidade(@RequestBody @Valid CidadesForm form,
			UriComponentsBuilder uriBuilder) {
		Cidades cidade = form.converter();
		cidadeRepository.save(cidade);
		URI uri = uriBuilder.path("/cidades/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new CidadesDto(cidade));

	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<DetalhesDaCidadeDto> consultaCidadePeloNome(@PathVariable String nome) {
		Optional<Cidades> cidade = Optional.ofNullable(cidadeRepository.findByNome(nome));

		if (cidade.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaCidadeDto(cidade.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/estado/{estado}")
	public ResponseEntity<DetalhesDaCidadeDto> consultaCidadePeloEstado(@PathVariable String estado) {
		Optional<Cidades> cidade = cidadeRepository.findByEstado(estado);

		if (cidade.isPresent()) {
			return ResponseEntity.ok(new DetalhesDaCidadeDto(cidade.get()));
		}
		return ResponseEntity.notFound().build();
	}

}
