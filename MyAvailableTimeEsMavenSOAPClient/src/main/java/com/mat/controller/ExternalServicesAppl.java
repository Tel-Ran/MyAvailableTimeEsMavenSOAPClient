package com.mat.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mat.json.Constants;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiba on 06.10.2015.
 */
public class ExternalServicesAppl {
    
/*	@Bean
	public HessianProxyFactoryBean iExternalServices() {
	    HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
	    factory.setServiceUrl("http://localhost:8080/MyAvailableTimeEsMaven/external_services.service");
	    factory.setServiceInterface(IExternalServices.class);
	    return factory;
	}*/
	
	/*@Autowired
	private static IExternalServic
	es exServ;	
	
	*/
	
	private static Credential credential;
	
	public static void main(String[] args) throws IOException {
    	
    
		
    	//AbstractApplicationContext ctx=new FileSystemXmlApplicationContext("beans.xml");
        //IExternalServices exServ = (IExternalServices) ctx.getBean("iExternalServices");
        //String test = exServ.testMethod();
        //System.out.println(test);
        
		
			   /* for (Document document : db.getCollection("Credentials").find()) {
	    	 // 
	    	  System.out.println(credential);*/

	    //}
	    
		
		// Credential foo = mongoTemplate.getConverter().read(Foo.class, obj);  
		
		
		
        
        
        
        /*BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        float result = 0;
        while(true){
            System.out.println("enter calculation expression or exit: ");
            String line=console.readLine();
            if(line == null || line.equalsIgnoreCase("exit"))
                break;
            String [] operands = line.split(" ");
            if (operands.length != 3){
                System.out.println("format expression should be <op1> <operation> <op2>");
                continue;
            }
            float op1 = Float.parseFloat(operands[0]);
            float op2 = Float.parseFloat(operands[2]);
            switch (operands[1]) {
                case "+": result=exServ.add(op1,op2);break;
                case "-": result=exServ.subtract(op1,op2);break;
                case "/": result=exServ.divide(op1,op2);break;
                case "*": result=exServ.multiply(op1,op2);break;
                default: System.out.println("Wrong operation repeat expression entering");continue;
            }
            System.out.println(result);
        }
        System.out.println("Good Bye");
    */}
}
