package br.com.meta.prova.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode

public class ReportRequest {
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

}
