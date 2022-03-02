package br.com.api.easyfood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.easyfood.api.openApi.CozinhaControllerOpenApi;
import br.com.api.easyfood.domain.model.Cozinha;
import br.com.api.easyfood.api.assembler.CozinhaDtoAssembler;
import br.com.api.easyfood.api.model.dto.CozinhaDto;
import br.com.api.easyfood.domain.repository.CozinhaRepository;
import br.com.api.easyfood.domain.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController implements CozinhaControllerOpenApi{
	
	@Autowired
	CozinhaService cozinhaService;
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired
	CozinhaDtoAssembler cozinhaDtoAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha){
		
		return cozinhaService.salvar(cozinha);
	}
	
	
	@Override
	@GetMapping
	public List<CozinhaDto> listar(){
		
		List<Cozinha> cozinhas = cozinhaService.listar();		
		
		return cozinhaDtoAssembler.toCollectionModel(cozinhas);
	}
	
//	@GetMapping("/{cozinhaId}")
//	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
//		
//		Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
//		
//		if(cozinha.isPresent()) {
//			return ResponseEntity.ok(cozinha.get());
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
}
