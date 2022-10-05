package com.deekol.trafficdocsrest.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.deekol.trafficdocsrest.domain.enums.EPay;
import com.deekol.trafficdocsrest.domain.enums.EPost;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "docs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	@Column(name = "post")
	@Enumerated(EnumType.STRING)
	private EPost ePost;
	
	@Column(name = "pay")
	@Enumerated(EnumType.STRING)
	private EPay ePay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consumer_id")
	private CounterpartyEntity counterpartyEntityConsumer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractor_id")
	private CounterpartyEntity counterpartyEntityContractor;

	@OneToMany(mappedBy = "docsEntity")
	private Set<TripEntity> tripEntity;
}
