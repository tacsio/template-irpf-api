package com.tacsio.ativo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "ticket" }))
public class Ativo extends PanacheEntity {

	@CNPJ
	private String cnpj;

	@NotBlank
	private String razaoSocial;

	@NotBlank
	private String ticket;

	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	protected Ativo() {
	}

	public Ativo(@CNPJ String cnpj, @NotBlank String razaoSocial, @NotBlank String ticket, Tipo tipo) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.ticket = ticket;
		this.tipo = tipo;
	}

	public String ticket() {
		return this.ticket;
	}

	public String tipo() {
		return this.tipo.name();
	}

}