package com.tacsio.corretora.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tacsio.corretora.Corretora;

public class CorretoraModel {

	@NotNull
	private final Long cpnj;
	@NotBlank
	private final String razaoSocial;

	public CorretoraModel(Long cnpj, String razaoSocial) {
		this.cpnj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public Corretora toEntity() {
		return new Corretora(this.cpnj, this.razaoSocial);
	}
}