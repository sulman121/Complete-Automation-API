package PostTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.Base;
import Utilities.RandomDataGenrator;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewEmployee extends Base {

	RequestSpecification httprequest;
	Response response;

	String empName = RandomDataGenrator.empName();
	String empSalary = RandomDataGenrator.empSal();
	String empAge = RandomDataGenrator.empAge();

	@BeforeClass
	public void createemployee() throws InterruptedException {
		logger.info("*****   Create an Employee Api Start Testing   *****");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();

		JSONObject requestparam = new JSONObject();

		requestparam.put("name", empName);
		requestparam.put("salary", empSalary);
		requestparam.put("age", empAge);

		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestparam.toJSONString());

		response = httprequest.request(Method.POST, "/create");

		Thread.sleep(4000);

	}

	@Test(priority=1)
	public void StatusCode() {
		int statuscode = response.getStatusCode();
		logger.info("This is the Status Code ===>> "+statuscode);
		System.out.println(statuscode);
	}

	@Test(priority=2)
	public void Responsebody() {
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		logger.info("This is the Response Body ====>>>  "+responsebody);
		Assert.assertEquals(responsebody.contains(empName), true);
	}
	
	@Test(priority=3)
	public void CheckStatusLine() {
		String statusline=response.getStatusLine();
		logger.info("This is the Status Line===>>  "+statusline);
		System.out.println(statusline);
		
	}
	
	@AfterClass
	public void TesrDown() {
	   logger.info("*****   TestFinish   *****");
	}
	
	
	
	
	
	

}
