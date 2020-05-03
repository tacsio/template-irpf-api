package com.tacsio.negociacao;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Positive;

import com.tacsio.ativo.Ativo;
import com.tacsio.corretora.Corretora;
import com.tacsio.usuario.Usuario;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
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

	// @ManyToOne  TODO: remover quando adiciona auth
	@Transient
	private Usuario dono;

	protected Negociacao() {
	}

	public Negociacao(Integer ano, Tipo tipo, Integer quantidade, Long total, Ativo ativo, Corretora custodiante,
			Usuario dono) {
		this.ano = ano;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.total = total;
		this.ativo = ativo;
		this.custodiante = custodiante;
		this.dono = dono;
	}
}