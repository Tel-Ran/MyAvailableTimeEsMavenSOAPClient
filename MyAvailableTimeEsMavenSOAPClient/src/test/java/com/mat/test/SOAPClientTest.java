package com.mat.test;

import static org.junit.Assert.*;

import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gson.Gson;
import com.mat.interfaces.IExternalServices;
import com.mat.json.Constants;
import com.mat.json.Scheduler;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"beans.xml"})
public class SOAPClientTest {
	
	private static final String ACCOUNT_NAME = "google";

	private static final int USER_ID = 1;

	private static final String SCHEDULER_NAME = null;

	String testAnswer = "If you see this hessian service works";

/*public HessianProxyFactoryBean iExternalServices() {
	    HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
	    factory.setServiceUrl("http://localhost:8080/MyAvailableTimeEsMaven/external_services.service");
	    factory.setServiceInterface(IExternalServices.class);
	    return factory;
	}*/
	@Autowired
	private IExternalServices exServ;
	
	private static GoogleCredential credential;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		GoogleCredential credential = new GoogleCredential.Builder().setJsonFactory(Constants.JSON_FACTORY)
			     .setTransport(Constants.HTTP_TRANSPORT).setClientSecrets(Constants.CLIENT_ID, Constants.CLIENT_SECRET).build();
			credential.setAccessToken(Constants.ACCESS_TOKEN);
			credential.setRefreshToken(Constants.REFRESH_TOKEN);
			System.out.println(credential);
			
	}
/*
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}*/

	@Test
	public void testMethodTest() {
		assertEquals(testAnswer, exServ.testMethod());
	}
	
	
/*	public void tesSetCredentials() {
		@Test
		Scheduler scheduler = new Scheduler();
		scheduler.setAccountName(ACCOUNT_NAME);
		scheduler.setShedulerName(SCHEDULER_NAME);
		exServ.setCredential(USER_ID, scheduler, credential);
		
	//	void setCredential(int userId, Scheduler scheduler, Credential credential);
			}

*/
}
