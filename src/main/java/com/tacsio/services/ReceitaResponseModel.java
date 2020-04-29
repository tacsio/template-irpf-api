package com.tacsio.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceitaResponseModel {

	private String nome;
	private String cnpj;

	public ReceitaResponseModel(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	@Override
	public String toString() {
		return "ReceitaResponseModel [cnpj=" + cnpj + ", nome=" + nome + "]";
	}
}
