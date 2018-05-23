package com.restapi.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	//GET method
	public void get(String url) throws ClientProtocolException, IOException{
		
		HttpClients.createDefault();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
		//URL status code
		int StatusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code or url: "+StatusCode);
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UFT-8");
		//convert above string to json format
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response Json from api: "+responseJson);
		
	    //header response
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
	
		for(Header header : headersArray){
			allHeaders.put(header.getName(), header.getValue());
			
		}
		System.out.println("Headers Array: "+allHeaders);
	}
	
	
	
	
	
	
}
