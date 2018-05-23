package com.restapi.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.client.RestClient;

public class GetApiTest extends TestBase {

		public GetApiTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

		
		TestBase testBase = new TestBase();
		String serviceurl;
		String apiUrl;
		String url;
		RestClient restClient;
		
		@BeforeTest
		public void setUp() throws ClientProtocolException, IOException, NullPointerException{
			serviceurl = prop.getProperty("URL");
			apiUrl = prop.getProperty("serviceURL");
			
			url = serviceurl + apiUrl;
			
		}
	
	@Test
	public void getApiTest() throws ClientProtocolException, IOException, NullPointerException{
		restClient = new RestClient();
		restClient.get(url);
	}
}
