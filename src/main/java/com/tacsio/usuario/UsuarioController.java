package com.tacsio.usuario;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioController {
	
	@POST
	@PermitAll
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario cadastrarUsuario(@Valid NovoUsuarioDTO request) {
		Usuario novoUsuario = request.toEntity();
		novoUsuario.persist();

		return novoUsuario;
	}
}