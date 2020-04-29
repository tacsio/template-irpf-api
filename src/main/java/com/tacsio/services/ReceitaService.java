package com.tacsio.services;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/cnpj")
@RegisterRestClient(configKey = "receita-service")
public interface ReceitaService {

	@GET
	@Path("/{cnpj}")
	Optional<ReceitaResponseModel> getByCnpj(@PathParam("cnpj") String cnpj);
}