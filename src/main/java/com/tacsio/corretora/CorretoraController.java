package com.tacsio.corretora;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tacsio.corretora.apimodel.CriarCorretoraModel;
import com.tacsio.service.ReceitaResponseModel;
import com.tacsio.service.ReceitaService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/corretora")
@Transactional
public class CorretoraController {

	@Inject
	@RestClient
	private ReceitaService receitaService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Corretora novaCorretora(CriarCorretoraModel model) {
		Corretora novaCorretora = model.toEntity();
		novaCorretora.persist();

		return novaCorretora;
	}

	@GET
	@Path("/{cnpj}")
	public String consultaRazaoSocial(@PathParam("cnpj") String cnpj) {

		String cleanedCnpj = cleanCnpj(cnpj);
		Optional<ReceitaResponseModel> empresa = receitaService.getByCnpj(cleanedCnpj);

		if (empresa.isPresent()) {
			return empresa.get().getNome();
		} else {
			return "not found";
		}
	}

	private String cleanCnpj(String cnpj) {
		return cnpj.trim().replace("/", "").replace(".", "");
	}

}