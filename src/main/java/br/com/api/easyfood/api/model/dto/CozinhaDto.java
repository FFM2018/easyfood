package br.com.api.easyfood.api.model.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "cozinhas")
public class CozinhaDto extends RepresentationModel<CozinhaDto>{
	private String nome;
	
}
