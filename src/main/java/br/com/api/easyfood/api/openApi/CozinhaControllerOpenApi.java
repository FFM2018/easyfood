package br.com.api.easyfood.api.openApi;

import java.util.List;

import br.com.api.easyfood.api.model.dto.CozinhaDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApi {
	
	@ApiOperation("Lista os estados")
	List<CozinhaDto> listar();
}
