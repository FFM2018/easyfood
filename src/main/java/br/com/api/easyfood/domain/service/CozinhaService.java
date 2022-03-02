package br.com.api.easyfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import br.com.api.easyfood.api.model.dto.CozinhaDto;
import br.com.api.easyfood.domain.model.Cozinha;
import br.com.api.easyfood.domain.repository.CozinhaRepository;

@Service
public class CozinhaService {

	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {		
		
		return cozinhaRepository.save(cozinha);
	}

	public List<Cozinha> listar() {
		
		return cozinhaRepository.findAll();
	}

//	public Optional<Cozinha> buscar(Long id) {
//		
//		return cozinhaRepository.findById(id);
//	}

}
