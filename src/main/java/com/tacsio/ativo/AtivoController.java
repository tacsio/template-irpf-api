package com.tacsio.ativo;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ativos")
public class AtivoController {

	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Ativo cadastrarAtivo(@Valid NovoAtivoDTO request) {
		Ativo novoAtivo = request.toEntity();
		novoAtivo.persist();

		return novoAtivo;
	}
}