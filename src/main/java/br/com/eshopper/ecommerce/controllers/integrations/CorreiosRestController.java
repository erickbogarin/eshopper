package br.com.eshopper.ecommerce.controllers.integrations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.eshopper.ecommerce.models.CorreiosDto;
import br.com.eshopper.ecommerce.soap.correios.CServico;
import br.com.eshopper.ecommerce.ws.CorreiosClientWS;

@RestController
@RequestMapping(value = "/v1/correios")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CorreiosRestController {

	@Autowired
	private CorreiosDto correios;

	@RequestMapping(value = "calculate")
	public CorreiosDto correios(@RequestParam(value = "cep") String cep) throws InterruptedException {
		
		List<CServico> services = CorreiosClientWS.calculate(cep);
		if(!cep.isEmpty())
			saveResult(services, cep);
		else correios.clear();

		return correios;
	}

	private void saveResult(List<CServico> services, String cep) {
		correios.cep(cep);
		correios.freight(services.get(0).getValor());
		correios.msgError(services.get(0).getMsgErro());
		correios.deadline(services.get(0).getPrazoEntrega());
	}

	public CorreiosDto getCorreios() {
		return correios;
	}

}
