package com.tacsio.corretora;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.tacsio.services.receita.ReceitaResponseModel;
import com.tacsio.services.receita.ReceitaService;
import com.tacsio.util.Utils;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hibernate.validator.constraints.br.CNPJ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/consulta-cnpj")
public class ConsultaReceitaController {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaReceitaController.class);

	@Inject
	@RestClient
	private ReceitaService receitaService;

	@GET
	public String consultaRazaoSocial(@QueryParam("cnpj") @CNPJ String cnpj) {
		ReceitaResponseModel empresaResponse = receitaService.getByCnpj(Utils.cleanCnpj(cnpj));

		if (empresaResponse.isOk()) {
			return empresaResponse.getNome();
		} else {
			logger.error("Error: {}", empresaResponse.getMessage());
			return "not found";
		}
	}
}