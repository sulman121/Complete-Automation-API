package GetTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllEmployeesInfo extends Base{

	RequestSpecification httprequest;
	Response response;

	@BeforeClass
	public void Allemployeesinfo() {
		
		logger.info("******Test Started=====>>>>   ");

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		httprequest = RestAssured.given();

		response = httprequest.request(Method.GET, "/employees");

	}

	@Test
	public void ResponseBody() {
		
	//	logger.info("******  Test Response Body ======>>>>  ");

		String responsebody = response.getBody().asString();
		System.out.println(responsebody);

	}

	@Test
	public void ResponseTime() {
		logger.info("******Test Response time  =====>>>>   ");

		long responsetime = response.getTime();
		logger.info("Response Time is "+responsetime);        
		System.out.println(responsetime);

	}
	
	@Test
	public void StatusCode() {
		int statuscode=response.getStatusCode();
	    
		logger.info("Status code ====>>> "+statuscode);
		AssertJUnit.assertEquals(statuscode, 200);
	
	}
	
	
	
	
	

}
