package org.salemelrahal.jbpm.rest.endpoint.v1;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.salemelrahal.jbpm.awesome.model.Accident;

@Path(value = "/accident/v1")
public interface AccidentEndpoint {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response create(Accident accident);
}
