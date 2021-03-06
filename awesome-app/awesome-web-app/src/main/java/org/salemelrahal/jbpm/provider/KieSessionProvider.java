package org.salemelrahal.jbpm.provider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.jbpm.runtime.manager.impl.RuntimeEnvironmentBuilder;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.EnvironmentName;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEnvironment;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.manager.RuntimeManagerFactory;
import org.kie.api.task.TaskService;
import org.kie.internal.runtime.manager.context.EmptyContext;
import org.kie.internal.runtime.manager.context.ProcessInstanceIdContext;

public class KieSessionProvider {
	private RuntimeManager runtimeManager;
	
	@PersistenceUnit(unitName = "org.salemelrahal.jbpm.awesome")
	private EntityManagerFactory entityManagerFactory;

	public RuntimeManager getRuntimeManager(ReleaseId releaseId) {
		RuntimeManagerFactory runtimeManagerFactory = RuntimeManagerFactory.Factory.get();

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.newKieContainer(releaseId);
		RuntimeEnvironment runtimeEnvironment = RuntimeEnvironmentBuilder.getDefault()
			.entityManagerFactory(entityManagerFactory)
			.persistence(true)
			.knowledgeBase(kieContainer.getKieBase())
			.addEnvironmentEntry(EnvironmentName.ENTITY_MANAGER_FACTORY, entityManagerFactory)
			.get();
		return runtimeManagerFactory.newPerProcessInstanceRuntimeManager(runtimeEnvironment, getIdentifier());
	}
	
	public KieSession newKieSession() {
		if (runtimeManager == null) {
			runtimeManager = getRuntimeManager(getReleaseId());
		}
		
		return runtimeManager.getRuntimeEngine(EmptyContext.get()).getKieSession();
	}
	
	public KieSession getKieSession(long processInstanceId) {
		if (runtimeManager == null) {
			runtimeManager = getRuntimeManager(getReleaseId());
		}
		
		return runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(processInstanceId)).getKieSession();
	}
	
	public TaskService getTaskService(long processInstanceId) {
		if (runtimeManager == null) {
			runtimeManager = getRuntimeManager(getReleaseId());
		}
		
		return runtimeManager.getRuntimeEngine(ProcessInstanceIdContext.get(processInstanceId)).getTaskService();
	}
	
	public ReleaseId getReleaseId() {
		String groupId = "org.salemelrahal.jbpm";
		String artifactId = "awesome-kjar";
		String version = "1.0.0-SNAPSHOT";
		
		KieServices kieServices = KieServices.Factory.get();
		return kieServices.newReleaseId(groupId, artifactId, version);
	}

	protected String getIdentifier() {
		return "new";
	}
}
