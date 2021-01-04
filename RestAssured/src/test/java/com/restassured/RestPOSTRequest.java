package com.restassured;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestPOSTRequest {
	
	@Test(dataProvider = "empdataprovider")
	void postMethod(String eusername, String epassword){
		
		
		RestAssured.baseURI = "https://reqres.in/api/users/";
				
		//https://reqres.in/api/users?page=2
		
		RequestSpecification httprequest = RestAssured.given();
		
		
		JSONObject requestParams =new JSONObject();
		requestParams.put("Username",eusername);
		requestParams.put("Password",epassword);
		requestParams.put("Username",eusername);
		requestParams.put("Password",epassword);
		requestParams.put("Username",eusername);
		requestParams.put("Password",epassword);
		
		httprequest .header("Contant - Type","application/json");
		
		httprequest.body(requestParams.toJSONString());
		
		Response response = httprequest.request(Method.POST,"/create");
		
		
		
		
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is :"+responseBody);
		
		Assert.assertEquals(responseBody.contains(eusername),true);
		Assert.assertEquals(responseBody.contains(epassword),true);
		
		int statusCode=response.getStatusCode();
		
		System.out.println("status code is:"+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
	}
		
		@DataProvider(name="empdataprovider")
		String [][] getEmpData() throws IOException
		{
			String path = System.getProperty("user.dir")+"/src/test/java/com/restassured/Testdata.xlsx";
			
			int rownum= ExcelUtils.getRowCount(path, "Sheet1");
			int colcount = ExcelUtils.getcellCount(path, "Sheet1",1);
			
			String empdata[][] = new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++) {
				for(int j= 0;j< colcount;j++) {
					
					empdata[i -1][j] = ExcelUtils.getcellData(path, "Sheet1", i, j);
				}
			}
			 return(empdata);
		}
		
		

	}


