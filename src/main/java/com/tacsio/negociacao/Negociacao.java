package com.tacsio.negociacao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.tacsio.ativo.Ativo;
import com.tacsio.corretora.Corretora;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Negociacao extends PanacheEntity{

	@Positive
	private int ano;

	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Positive
	private int quantidade;

	@Positive
	private long preco;	

	@ManyToOne
	private Ativo ativo;

	@ManyToOne
	private Corretora custodia;
	
}