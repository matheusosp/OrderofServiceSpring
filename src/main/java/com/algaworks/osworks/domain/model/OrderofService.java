package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.algaworks.osworks.api.model.Comment;
import com.algaworks.osworks.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "orderofservice")
public class OrderofService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne
	private Cliente cliente; 
	
	@NotBlank
	private String description;
	
	@NotNull
	private BigDecimal price; 
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private StatusOrder status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataOpening;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalization;
	
	@OneToMany(mappedBy = "orderService")
	private List<Comment> comments = new ArrayList<>();	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
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
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderofService other = (OrderofService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
