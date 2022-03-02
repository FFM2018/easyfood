package br.com.api.easyfood.domain.repository;

import org.springframework.stereotype.Repository;

import br.com.api.easyfood.domain.model.Cozinha;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
}
