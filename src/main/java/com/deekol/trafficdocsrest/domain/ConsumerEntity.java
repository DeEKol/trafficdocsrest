package com.deekol.trafficdocsrest.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "consumer")
@Data
@EqualsAndHashCode(callSuper = true)
public class ConsumerEntity extends Participant {
	@OneToOne(mappedBy = "consumerEntity")
	private TripEntity tripEntity;
	
	@OneToOne(mappedBy = "consumerEntity")
	private DocsEntity docsEntity;
}
