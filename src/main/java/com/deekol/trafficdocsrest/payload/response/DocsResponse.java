package com.deekol.trafficdocsrest.payload.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocsResponse {
	private Long id;
	private LocalDate date;
	private Boolean post;
	private Boolean pay;
	private String consumer;
	private String contractor;
}
