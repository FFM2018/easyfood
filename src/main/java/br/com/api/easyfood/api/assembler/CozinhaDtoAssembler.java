package br.com.api.easyfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.api.easyfood.api.controller.CozinhaController;
import br.com.api.easyfood.api.model.dto.CozinhaDto;
import br.com.api.easyfood.domain.model.Cozinha;

@Component
public class CozinhaDtoAssembler extends RepresentationModelAssemblerSupport<Cozinha, CozinhaDto>{
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CozinhaDtoAssembler() {
		super(CozinhaController.class, CozinhaDto.class);
	}
	
	public List<CozinhaDto> toCollectionModel(List<Cozinha> cozinhas){
		return cozinhas.stream()
				.map(cozinha -> toModel(cozinha))
				.collect(Collectors.toUnmodifiableList());
				
	}
	
	@Override
	public CozinhaDto toModel(Cozinha cozinha) {
		
		CozinhaDto cozinhaDto = instantiateModel(cozinha);
		modelMapper.map(cozinha, cozinhaDto);
		
		return cozinhaDto;
	}
}

