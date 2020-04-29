package com.tacsio.negociacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/negociacoes")
public class NegociacaoController {

	@Inject
	private EntityManager manager;

	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarNegociacao(NovaNegociacaoDTO request) {
		Negociacao novaNegociacao = request.toEntity(manager);
		novaNegociacao.persist();

		return Response.ok(novaNegociacao)
			.status(Response.Status.CREATED)
			.build();
	}
}