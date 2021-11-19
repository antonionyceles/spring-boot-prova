package br.com.meta.prova;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.meta.prova.model.Funcionario;
import br.com.meta.prova.model.Usuario;
import br.com.meta.prova.repository.FuncionarioRepository;
import br.com.meta.prova.service.FuncionarioService;

@SpringBootTest
class ProvaApplicationTests {
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private FuncionarioService service;

	@Test
	void contextLoads() {
		Funcionario func = new Funcionario(Long.parseLong("1"),"085.100.085-15","NORMA","MARIA MUNIZ CELES",new Date(),new Usuario(Long.parseLong("1"),"norma.celes","123456"));
		
//		try {
//			byte[] report =  service.generateReport();
//			assertNotNull(report);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//		func=	repository.save(func);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		List<VeiculoDTO> veiculos = repository.findAllByPlacaOrModelo("BRAVA");
		
	}

}
