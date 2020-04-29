package com.tacsio.negociacao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

import com.tacsio.ativo.Ativo;
import com.tacsio.corretora.Corretora;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Negociacao extends PanacheEntity {

	@Positive
	private Integer ano;

	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Positive
	private Integer quantidade;

	@Positive
	private Long total;

	@ManyToOne
	private Ativo ativo;

	@ManyToOne
	private Corretora custodiante;

	protected Negociacao() {
	}

	public Negociacao(Integer ano, Tipo tipo, Integer quantidade, Long total, Ativo ativo, Corretora custodiante) {
		this.ano = ano;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.total = total;
		this.ativo = ativo;
		this.custodiante = custodiante;
	}
}