package com.deekol.trafficdocsrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deekol.trafficdocsrest.domain.DocsEntity;
import com.deekol.trafficdocsrest.payload.response.DocsResponse;
import com.deekol.trafficdocsrest.payload.response.MessageResponse;
import com.deekol.trafficdocsrest.repository.CounterpartyRepository;
import com.deekol.trafficdocsrest.repository.DocsRepository;
import com.deekol.trafficdocsrest.repository.TripRepository;
import com.deekol.trafficdocsrest.utils.docs.DocsUtils;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/create")
@AllArgsConstructor
@CrossOrigin
public class CreateController {
	private final DocsRepository docsRepository;
	private final CounterpartyRepository counterpartyRepository;
	private final TripRepository tripRepository;
	
	@GetMapping("/docs.xls")
	public ResponseEntity<?> getAll() {
		
		DocsUtils.createDocsUtil();
		
		
		return ResponseEntity.ok(new MessageResponse("docs.xls create!"));
	}
}
