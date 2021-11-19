package br.com.meta.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.meta.prova.dto.VeiculoDTO;
import br.com.meta.prova.model.Veiculo;

@Repository
public interface VeiculoRepository  extends JpaRepository<Veiculo, Integer> {

	@Query("SELECT new br.com.meta.prova.dto.VeiculoDTO(v) FROM Veiculo v WHERE UPPER(v.modelo.nome) LIKE CONCAT('%',:placaModelo,'%') OR UPPER(v.placa) LIKE CONCAT('%',:placaModelo,'%') ")
	public List<VeiculoDTO> findAllByPlacaOrModelo(@Param("placaModelo")  String placaModelo);
}
