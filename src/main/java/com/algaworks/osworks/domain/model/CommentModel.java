package com.algaworks.osworks.domain.model;

import java.time.OffsetDateTime;

public class CommentModel {

	private Long id;
	private String description;
	private OffsetDateTime dataSend;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OffsetDateTime getDataSend() {
		return dataSend;
	}
	public void setDataSend(OffsetDateTime dataSend) {
		this.dataSend = dataSend;
	}
	
	
}
