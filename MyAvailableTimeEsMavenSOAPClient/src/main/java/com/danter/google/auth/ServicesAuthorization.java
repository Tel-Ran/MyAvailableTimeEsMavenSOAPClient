package com.danter.google.auth;

import com.google.api.client.auth.oauth2.Credential;

public class ServicesAuthorization{
	
	Credential credential;

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	} 


/**
 * the same but in the map we store not whole Scheduler object but just a string from it	
 */
	
	/**
	 * get credential from map by userId and scheduler
	 */
/*	public Credential getCredential(int userId, Scheduler scheduler) {

		Credential credential = credentials.get(userId).get(scheduler.getSchedulerName());
		return credential;
	}*/

	/**
	 * store credential to map
	 */
	/*public void setCredential(int userId, Scheduler scheduler, Credential credential) {
		HashMap<String, Credential> tempMap = new HashMap<String, Credential>();
		tempMap.put(scheduler.getShedulerName(), credential);
		credentials.put(userId, tempMap);
	}
	*/	
	

	
	

}
