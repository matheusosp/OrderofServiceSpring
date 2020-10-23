package com.algaworks.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.osworks.domain.model.StatusOrder;

public class ModelOrderofService {

	private Long id;
	private ClienteModel cliente;
	private String description;
	private BigDecimal price;
	private StatusOrder status;
	private OffsetDateTime dataOpening;
	private OffsetDateTime dataFinalization;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public StatusOrder getStatus() {
		return status;
	}
	public void setStatus(StatusOrder status) {
		this.status = status;
	}
	public OffsetDateTime getDataOpening() {
		return dataOpening;
	}
	public void setDataOpening(OffsetDateTime dataOpening) {
		this.dataOpening = dataOpening;
	}
	public OffsetDateTime getDataFinalization() {
		return dataFinalization;
	}
	public void setDataFinalization(OffsetDateTime dataFinalization) {
		this.dataFinalization = dataFinalization;
	}
	
	
	
}
