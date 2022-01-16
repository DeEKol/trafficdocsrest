package com.deekol.trafficdocsrest.payload.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocsRequest {
	
	@NotNull
	private LocalDate date;
	@NotNull
	private Boolean post;
	@NotNull
	private Boolean pay;
	
	@NotBlank
	private String consumer;
	@NotBlank
	private String contractor;
}
