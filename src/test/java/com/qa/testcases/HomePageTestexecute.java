package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePageTest;

public class HomePageTestexecute {
	
HomePageTest homePageTest  = new HomePageTest();
 

public void execute() {
	
	//homePageTest.HomePageTestcase(TestCaseno, ToBeExecuted, onewayOrtwoway, Origincode, Destinationcode, firstNameexcel, lastnameexcel, genderdata, age, dob, Gender);


}
@Test
public void test1()
{
	
	Assert.assertEquals(1, 1);
}
}
