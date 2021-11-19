package br.com.meta.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.meta.prova.dto.VeiculoDTO;
import br.com.meta.prova.service.VeiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/veiculo")
@Api(value="API REST Prova")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	

	
	@CrossOrigin
	@GetMapping
	@ApiOperation(value="Retorna o veículo passando como parâmetro o modelo ou placa")
	public List<VeiculoDTO> downloadReport(@RequestParam("modeloPlaca") String modeloPlaca) {
		return veiculoService.findByModeloOrPlaca(modeloPlaca);
	}
	
	
	@CrossOrigin
	@PutMapping
	@PostMapping
	@ApiOperation(value="Cria o funcionarios passando como parâmetro os dados do Funcionario")
	public VeiculoDTO criarFuncionario(VeiculoDTO veiculo) {
		return veiculoService.save(veiculo);
	}
	
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	@ApiOperation(value="Remove o veículo passando como parâmetro o ID")
	public ResponseEntity<String> remover(@PathVariable  Integer id) {
		veiculoService.delete(id);
		 return (ResponseEntity<String>) ResponseEntity.ok("Funcionário removido");
		 
	}
	
	








}