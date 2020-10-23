package com.algaworks.osworks.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderServiceinput {
	
	@NotBlank
	private String description;
	
	@NotNull
	private BigDecimal price;
	
	@Valid
	@NotNull
	private ClienteIdInput cliente;
	
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
	public ClienteIdInput getCliente() {
		return cliente;
	}
	public void setCliente(ClienteIdInput cliente) {
		this.cliente = cliente;
	}
	
	
}
