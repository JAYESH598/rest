package com.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestGETRequests extends BaseClass{

	@Test
	void getMethod(){
		
		
		RestAssured.baseURI = //"https://reqres.in/api/users/";
				prop.getProperty("BaseUri");
				
		//https://reqres.in/api/users?page=2
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET);
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is :"+responseBody);
		
		int statusCode=response.getStatusCode();
		
		System.out.println("status code is:"+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
		
//		String statusLine =response.getStatusLine();
//		
//		System.out.println("status Line is:"+statusLine);
//		
//		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");	

		
	}
}
