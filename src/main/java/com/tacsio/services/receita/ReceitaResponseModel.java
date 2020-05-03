package com.tacsio.services.receita;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceitaResponseModel {

	private String nome;
	private String cnpj;
	private String status;
	private String message;

	public ReceitaResponseModel(String nome, String cnpj, String status, String message) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.status = status;
		this.message = message;
	}

	public boolean isOk() {
		return !this.status.equalsIgnoreCase("ERROR");
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getStatus(){
		return status;
	}

	public String getMessage(){
		return message;
	}

	@Override
	public String toString() {
		return "ReceitaResponseModel [cnpj=" + cnpj + ", message=" + message + ", nome=" + nome + ", status=" + status
				+ "]";
	}
}
