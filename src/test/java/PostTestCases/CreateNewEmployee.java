package PostTestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.Base;
import Utilities.RandomDataGenrator;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateNewEmployee extends Base{
	
	
	RequestSpecification httprequest;
	Response response;
	
	String empName=RandomDataGenrator.empName();
	String empSalary=RandomDataGenrator.empSal();
	String empAge=RandomDataGenrator.empAge();
	
	
	@BeforeClass
	public void createemployee() throws InterruptedException {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		JSONObject requestparam= new JSONObject();
		
		
		requestparam.put("name", empName);
		requestparam.put("salary", empSalary);
		requestparam.put("age", empAge);
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		response=httprequest.request(Method.POST,"/create");
		
		
		
		Thread.sleep(4000);
		
	}
	
	
	@Test
	public void StatusCode() {
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
	}
	
	
	@Test
	public void Responsebody() {
		String responsebody=response.getBody().asString();
		System.out.println(responsebody);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
