package br.com.meta.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.meta.prova.dto.VeiculoDTO;
import br.com.meta.prova.exception.ValidationException;
import br.com.meta.prova.model.Veiculo;
import br.com.meta.prova.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;
	


	public List<VeiculoDTO> findByModeloOrPlaca(String modeloPlaca) {
		return repository.findAllByPlacaOrModelo(modeloPlaca.toUpperCase());
		
	}



	public VeiculoDTO save(VeiculoDTO veiculoDTO) {
		Veiculo veiculo = new Veiculo(veiculoDTO);
		return new VeiculoDTO(repository.save(veiculo));
	}

	public void delete(Integer id) {
		try {
			repository.findById(id).map(record -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElseThrow();
		} catch (ValidationException e) {
			throw new ValidationException("Não foi encontrado Funcionário para remoção");
		}

	}
}
