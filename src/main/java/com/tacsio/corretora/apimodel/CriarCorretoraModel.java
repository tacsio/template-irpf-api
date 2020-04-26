package com.tacsio.corretora.apimodel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tacsio.corretora.Corretora;

public class CriarCorretoraModel {

	@NotNull
	private final Long cpnj;
	@NotBlank
	private final String razaoSocial;

	public CriarCorretoraModel(Long cnpj, String razaoSocial) {
		this.cpnj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public Corretora toEntity() {
		return new Corretora(this.cpnj, this.razaoSocial);
	}
}