package org.salemelrahal.jbpm.rest.endpoint.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.salemelrahal.jbpm.awesome.model.Accident;
import org.salemelrahal.jbpm.provider.KieSessionProvider;
import org.salemelrahal.jbpm.rest.endpoint.AccidentEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AccidentEndpointImpl implements AccidentEndpoint {
	private static final Logger LOG = LoggerFactory.getLogger(AccidentEndpointImpl.class);
	
	@Inject
	KieSessionProvider kieSessionProvider;

	public Response getInfo(long processInstanceId) {
		TaskService taskService = kieSessionProvider.getTaskService(processInstanceId);
		
		
		List<Long> taskids = taskService.getTasksByProcessInstanceId(processInstanceId);
		if (taskids.isEmpty()) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		Long taskid = taskids.get(0);
		
		Map<String, Object> taskContent = taskService.getTaskContent(taskid);
		
		Accident accident = (Accident) taskContent.get("taskAccident");
		//I propose instead of the above, the below:
		//Accident accident = taskContent.get("taskAccident", Accident.class);
		
		LOG.info("Return task accident:" + accident);
		
		
		return Response.ok(accident).build();
	}

	public Response create(Accident accident) {
		LOG.info("Creating " + accident);
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("accident", accident);
		ProcessInstance processInstance = kieSessionProvider.newKieSession().startProcess("awesome.accident", params);
		return Response.ok("Accident logged, thanks!" + processInstance.getId()).build();
	}
	
}
