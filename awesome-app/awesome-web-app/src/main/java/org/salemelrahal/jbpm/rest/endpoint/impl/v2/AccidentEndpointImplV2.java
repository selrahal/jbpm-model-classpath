package org.salemelrahal.jbpm.rest.endpoint.impl.v2;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import org.salemelrahal.jbpm.awesome.model.Accident;
import org.salemelrahal.jbpm.provider.OldKieSessionProvider;
import org.salemelrahal.jbpm.rest.endpoint.v2.AccidentEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AccidentEndpointImplV2 implements AccidentEndpoint {
	private static final Logger LOG = LoggerFactory.getLogger(AccidentEndpointImplV2.class);
	
	@Inject
	OldKieSessionProvider kieSessionProvider;

	public Response create(Accident accident) {
		LOG.info("Creating " + accident);
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("accident", accident);
		kieSessionProvider.newKieSession().startProcess("awesome.accident", params);
		return Response.ok("Accident logged, thanks!").build();
	}

}
