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

package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	HomePageTest homePageTest= new HomePageTest();
TestUtil testutil= new TestUtil();

	
	@FindBy(xpath = "//*[contains(@id,'-origin-airport-display-inner')]")
	public static
	List<WebElement> fromName;
	
	@FindBy(xpath = "//*[contains(@id,'-origin-airport-smarty-wrapper')]//*[contains(@id,'-origin-airport')]")
	public static
	List<WebElement> fromNameBox;
	
	@FindBy(xpath = "//*[contains(@id,'destination-airport-smarty-wrapper')]//*[contains(@id,'-destination-airport')]")
	public static
	List<WebElement> ToNameBox;
	
	@FindBy(xpath = "//div[contains(@id,'-dateRangeInput-display-start')]")
	public static
	List<WebElement> FromCalendar;
	// driver.findElement(By.xpath("//div[text()='19']")).click();
	 @FindBy(xpath = "//div[contains(@id,'-jam-cal-201810')]//div[text()='12']")
	 public static
	 List<WebElement> FromDate;
	 
	 @FindBy(xpath = "//div[contains(@id,'-dateRangeInput-display-end')]")
	 public static
	 List<WebElement> ToCalendar;
	 
	 @FindBy(xpath = "//div[contains(@id,'-jam-cal-201810')]//div[text()='19']")
	 public static
	 List<WebElement> ToDate;
		 
	 @FindBy(xpath = "//div[@class='search-form-inner']//button[@aria-label=\"Search\"]")
	 public static
	 WebElement searchButton;
	
	 @FindBy(xpath = "//*[@data-value='roundtrip']")
	 public static
	 List<WebElement> JourneyType;
	 @FindBy(xpath = "//*[@data-title='Round-trip']")
	 public static
	 List<WebElement> JourneyTypeOptionRoundTrip;
	
	 @FindBy(xpath = "//*[@aria-label='Select number of travellers and cabin class']")
	 public static
	 List<WebElement> numberOfPassengers;
	 @FindBy(xpath = "//div[contains(@id,'-travelersAboveForm-dialog_content')]//*[@title='Increment']")
	 public static
	 List<WebElement> incrementButton;
	 
	 @FindBy(xpath = "//*[contains(@id,'-compareToWrapper')]")
	 public static
	 List<WebElement> frame1;
	 
	 @FindBy(xpath = "//*[contains(@id,'-cabinType-widget-display')]")
	 public static
	 List<WebElement> TicketClass;
	
	 @FindBy(xpath = "//li[@data-title='Economy']")
	 public static
	 List<WebElement> TicketClassEconomy;
	

	// Initializing the Page Objects:
	public static void executeTestHomePage(String OriginCode ,String DestinationCode) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("KAYAK"));
		TestUtil.clickOn(driver, JourneyType.get(0), 5);
		TestUtil.clickOn(driver, JourneyTypeOptionRoundTrip.get(2), 5);
		TestUtil.clickOn(driver, numberOfPassengers.get(0), 5);
		TestUtil.clickOn(driver, incrementButton.get(4), 5);
		Actions builder = new Actions(driver);   
		builder.moveToElement(incrementButton.get(4),50, 50).click().build().perform();
		TestUtil.clickOn(driver, TicketClass.get(0), 5);
		TestUtil.clickOn(driver,TicketClassEconomy.get(0), 5);
		TestUtil.clickOn(driver, fromName.get(0), 5);
		TestUtil.senddata(driver, fromNameBox.get(0), 5,OriginCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-short-name,'"+OriginCode+"')]")));
		List<WebElement> webElementapiCodeFrom =driver.findElements(By.xpath("//li[contains(@data-short-name,'"+OriginCode+"')]"));
		webElementapiCodeFrom.get(0).click();
		TestUtil.senddata(driver, ToNameBox.get(0), 5,DestinationCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-short-name,'"+DestinationCode+"')]")));
		 List<WebElement> webElementapiCodeTo =driver.findElements(By.xpath("//li[contains(@data-short-name,'"+DestinationCode+"')]"));
		webElementapiCodeTo.get(0).click();
		FromCalendar.get(0).click();
		TestUtil.clickOn(driver, FromDate.get(0), 5);
		TestUtil.clickOn(driver, ToDate.get(0), 5);
		driver.get("https://www.expedia.ca/Flights-Search?flight-type=on&starDate=20%2F12%2F2018&endDate=12%2F06%2F2019&mode=search&trip=roundtrip&leg1=from%3AToronto%2C+ON%2C+Canada+%28YYZ-Pearson+Intl.%29%2Cto%3ADelhi%2C+India+%28DEL-Indira+Gandhi+Intl.%29%2Cdeparture%3A20%2F12%2F2018TANYT&leg2=from%3ADelhi%2C+India+%28DEL-Indira+Gandhi+Intl.%29%2Cto%3AToronto%2C+ON%2C+Canada+%28YYZ-Pearson+Intl.%29%2Cdeparture%3A12%2F06%2F2019TANYT&passengers=children%3A0%2Cadults%3A1%2Cseniors%3A0%2Cinfantinlap%3AY");     //homePage.searchButton.click(); 
	}
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public   void selectBasicsOfJourney()
	{
		
		
		TestUtil.clickOn(driver, JourneyType.get(0), 5);
		TestUtil.clickOn(driver, JourneyTypeOptionRoundTrip.get(2), 5);
		TestUtil.clickOn(driver, numberOfPassengers.get(0), 5);
		TestUtil.clickOn(driver, incrementButton.get(4), 5);
		Actions builder = new Actions(driver);   
		builder.moveToElement(incrementButton.get(4),50, 50).click().build().perform();
		TestUtil.clickOn(driver, TicketClass.get(0), 5);
		TestUtil.clickOn(driver,TicketClassEconomy.get(0), 5);
		
	}
	
	public   void  SelectOriginAndDestination( String OriginCode, String DestinationCode)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		TestUtil.clickOn(driver, fromName.get(0), 5);
		TestUtil.senddata(driver, fromNameBox.get(0), 5,OriginCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-short-name,'"+OriginCode+"')]")));
		List<WebElement> webElementapiCodeFrom =driver.findElements(By.xpath("//li[contains(@data-short-name,'"+OriginCode+"')]"));
		webElementapiCodeFrom.get(0).click();
		TestUtil.senddata(driver, ToNameBox.get(0), 5,DestinationCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-short-name,'"+DestinationCode+"')]")));
		 List<WebElement> webElementapiCodeTo =driver.findElements(By.xpath("//li[contains(@data-short-name,'"+DestinationCode+"')]"));
		webElementapiCodeTo.get(0).click();
		
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	

}
