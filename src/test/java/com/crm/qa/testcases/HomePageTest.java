package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.pages.FlightListPage;
import com.crm.qa.pages.FlightSelectionConfirmationPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.PaymentPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	HomePage homePage;
	FlightListPage flightListPage;
	FlightSelectionConfirmationPage flightSelectionConfirmationPage;
	PaymentPage paymentPage;
	TestUtil testUtil;
	String sheetName = "Sheet3";
	/**********************************************************************;
	* Project           : Selenium webdriver Mobile automation front end Hybrid framework
	*
	* Program name      : AppiumAutomationFramework
	*
	* Author            : Nimal krishna
	*
	* Date created      : 20160816
	*
	* Purpose           : Simple Gui Web portal automation framework
	*
	* Revision History  :
	*
	* Date        Author      Ref    Revision (Date in YYYYMMDD format) 
	* 20180818    Nimal      1      added BDD,TDD characters to the framework 
	*
	|**********************************************************************/
	
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage= new HomePage();
		flightListPage = new FlightListPage();
		flightSelectionConfirmationPage = new FlightSelectionConfirmationPage();
		paymentPage = new PaymentPage();
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}

	
	
	@Test(priority=1,dataProvider="getCRMTestData")
	public void HomePageTestcase(String TestCaseno, String ToBeExecuted, String onewayOrtwoway,String Origincode,String Destinationcode,String firstNameexcel,String lastnameexcel,String genderdata, String age, String dob, String Gender) throws InterruptedException, ParseException{
		
	homePage.executeTestHomePage(Origincode ,Destinationcode );
	    //String winHandleBefore = driver.getWindowHandle();
	    // Perform the click operation that opens new window       
	 // Switch to new window opened & Perform the actions on new window
	
	 flightListPage.executeFlightListPage();
	// Thread.sleep(3000);
	 flightSelectionConfirmationPage.executeFlightSelectionConfirmationPage();
	paymentPage.executePaymentpage(firstNameexcel, lastnameexcel, Gender, dob);
	  
	   
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
