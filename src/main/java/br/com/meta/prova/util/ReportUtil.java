package br.com.meta.prova.util;

import java.util.List;

import br.com.meta.prova.dto.FuncionarioDTO;

public class ReportUtil {

	public static StringBuilder generateTableAniver(List<FuncionarioDTO> funcL) {
		StringBuilder tableFunc = new StringBuilder();
		tableFunc.append("<table border=\"2\">");
		tableFunc.append("<tr>");
		tableFunc.append("<th>Nome</th>");
		tableFunc.append("<th>Sobrenome</th>");
		tableFunc.append("<th>Data de Nascimento</th>");
		tableFunc.append("</tr>");
		funcL.forEach(obj -> {
			tableFunc.append("<tr>");
			tableFunc.append("<td>");
			tableFunc.append(obj.getNome());
			tableFunc.append("</td>");
			tableFunc.append("<td>");
			tableFunc.append(obj.getSobrenome());
			tableFunc.append("</td>");
			tableFunc.append("<td>");
			tableFunc.append(obj.getDtNascimento());
			tableFunc.append("</td>");
			tableFunc.append("</tr>");

		});
		return tableFunc;
	}
}
