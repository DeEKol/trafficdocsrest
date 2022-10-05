package com.deekol.trafficdocsrest.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.dto.DocsXlsDto;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;
import com.deekol.trafficdocsrest.repository.DocsRepository;
import com.deekol.trafficdocsrest.repository.TripRepository;

@Service
public class CreateXlsService {
	
	private final DocsRepository docsRepository;
	private final CounterpartyRepository counterpartyRepository;
	private final TripRepository tripRepository;
	
	public CreateXlsService(DocsRepository docsRepository, CounterpartyRepository counterpartyRepository,
			TripRepository tripRepository) {
		this.docsRepository = docsRepository;
		this.counterpartyRepository = counterpartyRepository;
		this.tripRepository = tripRepository;
	}
	
	public DocsXlsDto createXlsDto() {
		DocsXlsDto docsXlsDto = DocsXlsDto.builder()
				.docsId(0)
				.docsDate(null)
				.contractorDescription(null)
				.consumerDescription(null)
				.tripDate(null)
				.tripDescription(null)
				.quantity(null)
				.quantityUnit(null)
				.price(null)
				.build();
		
		return docsXlsDto;
	}
	
//	public void CreateXlsDocs() {
//		
//	}
	
}
