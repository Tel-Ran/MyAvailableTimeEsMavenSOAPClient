package com.danter.google.auth;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A helper class for Google's OAuth2 authentication API.
 * @version 20130224
 * @author Matyas Danter
 */
public final class GoogleAuthHelper {

	/**
	 * Please provide a value for the CLIENT_ID constant before proceeding, set this up at https://code.google.com/apis/console/
	 */
	private static final String CLIENT_ID = "1044767536523-51m2bc0leb0lncl3e3cpkgblb5h5htun.apps.googleusercontent.com";
	/**
	 * Please provide a value for the CLIENT_SECRET constant before proceeding, set this up at https://code.google.com/apis/console/
	 */
	private static final String CLIENT_SECRET = "7ScqCNN8TvcxIhv169Lus_Vt";

	/**
	 * Callback URI that google will redirect to after successful authentication
	 */
	private static final String CALLBACK_URI = "http://localhost:8080/MyAvailableTimeEsMavenSOAPClient/index.jsp";
	
	// start google authentication constants
	private static final Iterable<String> SCOPE = Arrays.asList("profile;email".split(";"));
	//private static final Iterable<String> SCOPE = Arrays.asList("https://www.googleapis.com/auth/userinfo.profile;https://www.googleapis.com/auth/userinfo.email".split(";"));
	private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();
	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	private static final String TYPE_OF_SERVICE = "google";
	// end google authentication constants
	
	private String stateToken = null;
	
	private final GoogleAuthorizationCodeFlow flow;
	
	public ServicesAuthorization serAuth;
	private TokenInfo ti;
	
	/**
	 * Constructor initializes the Google Authorization Code Flow with CLIENT ID, SECRET, and SCOPE 
	 */
	public GoogleAuthHelper() {
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
				JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, SCOPE).build();
		
		//generateStateToken();
	}

	/**
	 * Builds a login URL based on client ID, secret, callback URI, and scope 
	 */
	public String buildLoginUrl() {
		
		final GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
		//url.
		System.out.println(url);
		System.out.println(url.setRedirectUri(CALLBACK_URI).setState(stateToken).build());
		return url.setRedirectUri(CALLBACK_URI).setState(stateToken).build();
		
	}
	
	/**
	 * Generates a secure state token 
	 */
	private void generateStateToken(){
		
		SecureRandom sr1 = new SecureRandom();
		
		stateToken = "google;"+sr1.nextInt();
		System.out.println("stateToken = "+stateToken);
	}
	
	/**
	 * Accessor for state token
	 */
	public String getStateToken(){
		return stateToken;
	}
	
	/**
	 * Expects an Authentication Code, and makes an authenticated request for the user's profile information
	 * @return JSON formatted user profile information
	 * @param authCode authentication code provided by google
	 */
//	public String getUserInfoJson(final String authCode) throws IOException {

	public void setCredential(final String authCode) throws IOException {

		final GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(CALLBACK_URI).execute();
		System.out.println("Response :"+response);
		
	final Credential credential = flow.createAndStoreCredential(response, null);
		/*	
		final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);
		System.out.println("requestFactory: "+requestFactory);
		
		
		// Make an authenticated request
		final GenericUrl url = new GenericUrl(USER_INFO_URL);
		System.out.println("Url: "+url);
		final HttpRequest request = requestFactory.buildGetRequest(url);
		System.out.println("request: "+request);
		
		request.getHeaders().setContentType("application/json");
		final String jsonIdentity = request.execute().parseAsString();
		System.out.println("jsonIdentity: "+jsonIdentity);
*/
		serAuth.setCredential(credential);

	}
	/**
	 * Store token information to map in External Services
	 * @param tokenId
	 */
	

	

}
