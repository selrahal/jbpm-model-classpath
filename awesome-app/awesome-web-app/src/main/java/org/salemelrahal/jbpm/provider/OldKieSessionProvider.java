package org.salemelrahal.jbpm.provider;

import javax.ejb.Singleton;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;

@Singleton
public class OldKieSessionProvider extends KieSessionProvider {
	
	public ReleaseId getReleaseId() {
		String groupId = "org.salemelrahal.jbpm";
		String artifactId = "awesome-kjar";
		String version = "2.0.0-SNAPSHOT";
		
		KieServices kieServices = KieServices.Factory.get();
		return kieServices.newReleaseId(groupId, artifactId, version);
	}
}
