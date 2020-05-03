package com.tacsio.corretora;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/corretoras")
public class CorretoraController {

	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Corretora novaCorretora(@Valid CriarCorretoraDTO model) {
		Corretora novaCorretora = model.toEntity();
		novaCorretora.persist();

		return novaCorretora;
	}
}