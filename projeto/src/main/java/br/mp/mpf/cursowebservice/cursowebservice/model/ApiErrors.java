package br.mp.mpf.cursowebservice.cursowebservice.model;

import java.time.Instant;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrors {
	
	private String code;
	private List<String> messages;
	private Integer errorCount;
	private Instant timestamp;

}
