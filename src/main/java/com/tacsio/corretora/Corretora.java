package com.tacsio.corretora;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cnpj"}))
public class Corretora extends PanacheEntity {

	@CNPJ
	private String cnpj;

	@NotBlank
	private String razaoSocial;

	protected Corretora() {}

	public Corretora(@CNPJ String cnpj, @NotBlank String razaoSocial) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "Corretora [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + "]";
	}
	
}