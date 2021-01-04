package com.restassured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	public static Properties prop; 

	public static FileInputStream fis; 
	 
	public static void Read() throws IOException {
		
		 prop = new Properties();
		
		fis = new FileInputStream("C:\\Users\\jv20273\\eclipse-workspace\\RestAssured\\config.properties"); 

	    prop.load(fis); 
	}
	
	
	
}


