package uk.co.automationtesting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class inhereted {
	
	@BeforeTest
	public void bftest()
	{
		System.out.println("before test");
	}
	
	
	@AfterTest
	public void aftest()
	{
		System.out.println("after test");
	}

}
