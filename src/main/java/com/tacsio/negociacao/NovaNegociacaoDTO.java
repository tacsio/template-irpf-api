package com.tacsio.negociacao;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.google.common.base.Preconditions;
import com.tacsio.ativo.Ativo;
import com.tacsio.corretora.Corretora;

public class NovaNegociacaoDTO {

	@Positive
	private final Integer ano;

	@NotNull
	private final Tipo tipo;

	@Positive
	private final Integer quantidade;

	@Positive
	private final Long total;

	@Positive
	private final Long idAtivo;

	@Positive
	private final Long idCustodiante;

	public NovaNegociacaoDTO(@Positive Integer ano, @NotNull Tipo tipo, @Positive Integer quantidade,
			@Positive Long total, @Positive Long idAtivo, @Positive Long idCustodiante) {
		this.ano = ano;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.total = total;
		this.idAtivo = idAtivo;
		this.idCustodiante = idCustodiante;
	}

	public Negociacao toEntity(EntityManager manager) {
		Ativo ativo = manager.find(Ativo.class, idAtivo);
		Corretora custodiante = manager.find(Corretora.class, idCustodiante);

		Preconditions.checkArgument(ativo != null,
				"Ativo não encontrado. O ativo deve existir antes de adiciona-lo a uma negociação.");
		Preconditions.checkArgument(custodiante != null,
				"Custodiante não encontrado. A corretora custodiante deve existir antes de adiciona-lo a uma negociação.");

		return new Negociacao(ano, tipo, quantidade, total, ativo, custodiante);
	}

}