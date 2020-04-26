package com.tacsio.corretora;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Corretora extends PanacheEntity {

	@NotNull
	private Long cnpj;

	@NotBlank
	private String razaoSocial;

	protected Corretora() {}

	public Corretora(@NotNull Long cnpj, @NotBlank String razaoSocial) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "Corretora [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}
	
}