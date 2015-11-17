package com.mat.test;

import static org.junit.Assert.*;

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
import com.mat.interfaces.IExternalServices;
import com.mat.json.Scheduler;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"beans.xml"})
public class SOAPClientTest {
	
	private static final String ACCOUNT_NAME = null;

	private static final int USER_ID = 0;

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
	
	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

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
	
	
	@Test
	public void tesSetCredentials() {
		Scheduler scheduler = new Scheduler();
		scheduler.setAccountName(ACCOUNT_NAME);
		scheduler.setShedulerName(SCHEDULER_NAME);
		exServ.setCredential(USER_ID, scheduler, credential);
		void setCredential(int userId, Scheduler scheduler, Credential credential);
		
		assertEquals(testAnswer, exServ.testMethod());
	}


}
