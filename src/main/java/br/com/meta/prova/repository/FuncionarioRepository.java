package br.com.meta.prova.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.meta.prova.dto.FuncionarioDTO;
import br.com.meta.prova.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	
	@Query("SELECT new br.com.meta.prova.dto.FuncionarioDTO(f) FROM Funcionario f WHERE f.cpf=:nomeCPF OR UPPER(f.nome) LIKE CONCAT('%',:nomeCPF,'%') OR UPPER(f.sobrenome) LIKE CONCAT('%',:nomeCPF,'%') ")
	public List<FuncionarioDTO> findAllByCpfOrNome(@Param("nomeCPF")  String nomeCPF);

	@Query("SELECT new br.com.meta.prova.dto.FuncionarioDTO(f) FROM Funcionario f WHERE f.cpf = :cpf")
	public Funcionario findByCPF(@Param("cpf") String cpf);

	@Query("SELECT new br.com.meta.prova.dto.FuncionarioDTO(f) FROM Funcionario f WHERE f.dtNascimento BETWEEN :startDate AND :endDate")
	public List<FuncionarioDTO> findAllByDtNascimento(Date startDate, Date endDate);

}
