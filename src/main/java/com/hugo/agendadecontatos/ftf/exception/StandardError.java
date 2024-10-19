package com.hugo.agendadecontatos.ftf.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardError {

	private Long timestamp;
	private Integer status;
	private String error;
	private String menssege;
	private String path;
	
	public StandardError() {
	}

	public StandardError(Long timestamp, Integer status, String error, String menssege, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.menssege = menssege;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMenssege() {
		return menssege;
	}

	public void setMenssege(String menssege) {
		this.menssege = menssege;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
