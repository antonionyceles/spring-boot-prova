package br.com.meta.prova.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.html2pdf.HtmlConverter;

import br.com.meta.prova.dto.FuncionarioDTO;
import br.com.meta.prova.exception.ValidationException;
import br.com.meta.prova.model.Funcionario;
import br.com.meta.prova.model.ReportRequest;
import br.com.meta.prova.repository.FuncionarioRepository;
import br.com.meta.prova.util.ReportUtil;

@Service
@Transactional
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public List<FuncionarioDTO> findAllByCpfOrNome(String nomeCpf) {
		return repository.findAllByCpfOrNome(nomeCpf.toUpperCase());
	}

	public FuncionarioDTO save(FuncionarioDTO func) {
		Funcionario funcionario = new Funcionario(func);
		return func = new FuncionarioDTO(repository.save(funcionario));
	}

	public void delete(Long id) {
		try {
			repository.findById(id).map(record -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
			}).orElseThrow();
		} catch (ValidationException e) {
			throw new ValidationException("Não foi encontrado Funcionário para remoção");
		}

	}

	public List<FuncionarioDTO> findAll() {

		Pageable page = PageRequest.of(0, 5);

		Page<FuncionarioDTO> entities = repository.findAll(page).map(FuncionarioDTO::fromEntity);
		return entities.getContent();
	}

	public FuncionarioDTO find(Long id) {

		return new FuncionarioDTO(repository.findById(id).get());
	}

	public byte[] generateReport(ReportRequest report, String filename) throws Exception {
		List<FuncionarioDTO> funcL = repository.findAllByDtNascimento(report.getStartDate(),report.getEndDate());
		try {

			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			StringBuilder resourceName = new StringBuilder();
			resourceName.append(".").append(File.separator).append("report")
			.append(File.separator).append("aniv_periodo.html");
		
			String html = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(resourceName.toString()).toURI())));
			html =html.replace("<div>table</div>", ReportUtil.generateTableAniver(funcL));
			
			HtmlConverter.convertToPdf(html, buffer);
			byte[] pdfAsBytes = buffer.toByteArray();
			try (FileOutputStream fos = new FileOutputStream(filename)) {
				fos.write(pdfAsBytes);
			}
			return pdfAsBytes;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
