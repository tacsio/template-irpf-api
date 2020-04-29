package com.tacsio.corretora;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.tacsio.services.ReceitaResponseModel;
import com.tacsio.services.ReceitaService;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hibernate.validator.constraints.br.CNPJ;

@Path("/corretoras")
public class CorretoraController {

	@Inject
	@RestClient
	private ReceitaService receitaService;

	@Transactional
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Corretora novaCorretora(@Valid CriarCorretoraDTO model) {
		Corretora novaCorretora = model.toEntity();
		novaCorretora.persist();

		return novaCorretora;
	}

	@GET
	public String consultaRazaoSocial(@QueryParam("cnpj") @CNPJ String cnpj) {

		String cleanedCnpj = cleanCnpj(cnpj);
		Optional<ReceitaResponseModel> empresa = receitaService.getByCnpj(cleanedCnpj);
		
		if (empresa.isPresent() && empresa.get().getNome() != null) {
			return empresa.get().getNome();
		} else {
			return "not found";
		}
	}

	private String cleanCnpj(String cnpj) {
		return cnpj.trim().replace("/", "").replace(".", "").replace("", "");
	}

}