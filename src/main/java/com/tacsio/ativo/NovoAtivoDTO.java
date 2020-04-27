package com.tacsio.ativo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

public class NovoAtivoDTO {

	@CNPJ
	private String cnpj;

	@NotBlank
	private String razaoSocial;

	@NotBlank
	private String ticket;

	@NotNull
	private Tipo tipo;

	public NovoAtivoDTO(@CNPJ String cnpj, @NotBlank String razaoSocial, @NotBlank String ticket, @NotNull Tipo tipo) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.ticket = ticket.toUpperCase();
		this.tipo = tipo;
	}

	public Ativo toEntity() {
		return new Ativo(cnpj, razaoSocial, ticket, tipo);
	}
	
}