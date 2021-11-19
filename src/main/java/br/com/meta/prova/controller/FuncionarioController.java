package br.com.meta.prova.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meta.prova.dto.FuncionarioDTO;
import br.com.meta.prova.model.ReportRequest;
import br.com.meta.prova.service.FuncionarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/funcionario")
@Api(value="API REST Prova")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	


	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna os funcionários passando como parâmetro nome ou CPF")
	public FuncionarioDTO getFuncionarioById(@PathVariable Long id) {
		return funcionarioService.find(id);
	}
	
	
	@GetMapping
	@ApiOperation(value="Retorna os funcionários passando como parâmetro nome ou CPF")
	public List<FuncionarioDTO> getFuncionarios() {
		return funcionarioService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/find/{nomeCpf}")
	@ApiOperation(value="Retorna os funcionários passando como parâmetro nome ou CPF")
	public List<FuncionarioDTO> getFuncionariosByNomeOrCpf(@PathVariable String nomeCpf) {
		return funcionarioService.findAllByCpfOrNome(nomeCpf.toUpperCase());
	}
	
	
	@PutMapping
	@PostMapping
	@ApiOperation(value="Cria e Atualiza o funcionario passando como parâmetro os dados do Funcionario")
	public FuncionarioDTO createFuncionario(@RequestBody FuncionarioDTO func) {
		return funcionarioService.save(func);
	}
	
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	@ApiOperation(value="Remove o funcionario passando como parâmetro o ID")
	public ResponseEntity<String> remover(@PathVariable  Long id) {
		 funcionarioService.delete(id);
		 return (ResponseEntity<String>) ResponseEntity.ok("Funcionário removido");
		 
	}
	
	
	@CrossOrigin
	@PostMapping(value="/report/generated")
	@ApiOperation(value="Retorna Relatório de Aniversariantes")
	public ResponseEntity<byte[]> downloadReportPdf(@RequestBody ReportRequest reportRequest) throws Exception {
		  HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    // Here you have to set the actual filename of your pdf
		    String filename = new Date().getTime() + "_aniversariantes.pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    ResponseEntity<byte[]> response = new ResponseEntity<>(funcionarioService.generateReport(reportRequest,filename), headers, HttpStatus.OK);
		    return response;
	}
	
	


}