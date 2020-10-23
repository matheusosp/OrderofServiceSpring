package com.algaworks.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem {

	private Integer Status;
	private OffsetDateTime dataHora;
	private String title;
	private List<field> fields;
	
	public static class field {
		
		private String name;
		private String message;
		
		public field(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}
		public String getName() {
			return name;
		}
		public void setNome(String name) {
			this.name = name;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<field> getFields() {
		return fields;
	}
	public void setFields(List<field> fields) {
		this.fields = fields;
	}
	
	
}
