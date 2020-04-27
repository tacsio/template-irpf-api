package com.tacsio.corretora;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

public class CriarCorretoraDTO {

	@CNPJ
	private final String cpnj;
	@NotBlank
	private final String razaoSocial;

	public CriarCorretoraDTO(String cnpj, String razaoSocial) {
		this.cpnj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public Corretora toEntity() {
		return new Corretora(this.cpnj, this.razaoSocial);
	}
}