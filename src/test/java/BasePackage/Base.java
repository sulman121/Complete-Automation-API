package BasePackage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {

	public static RequestSpecification httprequest;
	public static Response response;

	public Logger logger;

	@BeforeClass
	public void Setup() {

		logger = Logger.getLogger("Complete_Api_Automation_FrameWork");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);

	}
}
