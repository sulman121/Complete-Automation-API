package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenrator {

	public static String empName() {
		String genratedString=RandomStringUtils.randomAlphabetic(2);
		return ("Sulman"+genratedString);
	}
	
	public static String empSal() {
		String genratedString =RandomStringUtils.randomNumeric(5);
		return (genratedString);
	}
	
	public static String empAge() {
		String genratedString =RandomStringUtils.randomNumeric(2);
		return (genratedString);
	}
	
	
	
	
}
