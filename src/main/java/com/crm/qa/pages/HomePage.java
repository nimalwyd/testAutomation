package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.HomePageTest;

public class HomePage extends TestBase {
	HomePageTest homePageTest= new HomePageTest();


	
	@FindBy(xpath = "//*[contains(@id,'-origin-airport-display-inner')]")
	public
	List<WebElement> fromName;
	
	@FindBy(xpath = "//*[contains(@id,'-origin-airport-smarty-wrapper')]//*[contains(@id,'-origin-airport')]")
	@CacheLookup
	public
	List<WebElement> fromNameBox;
	
	@FindBy(xpath = "//*[contains(@id,'destination-airport-smarty-wrapper')]//*[contains(@id,'-destination-airport')]")
	@CacheLookup
	public
	List<WebElement> ToNameBox;
	
	@FindBy(xpath = "//div[contains(@id,'-dateRangeInput-display-start')]")
	public
	List<WebElement> FromCalendar;
	// driver.findElement(By.xpath("//div[text()='19']")).click();
	 @FindBy(xpath = "//div[contains(@id,'-jam-cal-201809')]//div[text()='29']")
	 public
	 List<WebElement> FromDate;
	 
	 @FindBy(xpath = "//div[contains(@id,'-dateRangeInput-display-end')]")
	 public
	 List<WebElement> ToCalendar;
	 
	 @FindBy(xpath = "//div[contains(@id,'-jam-cal-201810')]//div[text()='12']")
	 public
	 List<WebElement> ToDate;
		 
	 @FindBy(xpath = "//div[@class='search-form-inner']//button[@aria-label=\"Search\"]")
	 public
	 WebElement searchButton;
	
	 @FindBy(xpath = "//*[@data-value='roundtrip']")
	 @CacheLookup
	 public
	 List<WebElement> JourneyType;
	 @FindBy(xpath = "//*[@data-title='Round-trip']")
	 @CacheLookup
	 public
	 List<WebElement> JourneyTypeOptionRoundTrip;
	
	 @FindBy(xpath = "//*[@aria-label='Select number of travellers and cabin class']")
	 @CacheLookup
	 public
	 List<WebElement> numberOfPassengers;
	 @FindBy(xpath = "//div[contains(@id,'-travelersAboveForm-dialog_content')]//*[@title='Increment']")
	 public
	 List<WebElement> incrementButton;
	 
	 @FindBy(xpath = "//*[contains(@id,'-compareToWrapper')]")
	 public
	 List<WebElement> frame1;
	 
	 @FindBy(xpath = "//*[contains(@id,'-cabinType-widget-display')]")
	 public
	 List<WebElement> TicketClass;
	
	 @FindBy(xpath = "//li[@data-title='Economy']")
	 public
	 List<WebElement> TicketClassEconomy;
	
	
	
	
	
	
	// Initializing the Page Objects:
	public void executeTestHomePage(String OriginCode ,String DestinationCode) throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("KAYAK"));
		wait.until(ExpectedConditions.visibilityOf(JourneyType.get(0)));
		JourneyType.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(JourneyTypeOptionRoundTrip.get(2)));
		JourneyTypeOptionRoundTrip.get(2).click();
		wait.until(ExpectedConditions.visibilityOf(numberOfPassengers.get(0)));
		numberOfPassengers.get(0).click();
		//Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(incrementButton.get(0)));
		incrementButton.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(incrementButton.get(4)));
		incrementButton.get(4).click();
		Actions builder = new Actions(driver);   
		builder.moveToElement(incrementButton.get(4),50, 50).click().build().perform();
		//driver.switchTo().frame(frame1.get(0));
		wait.until(ExpectedConditions.invisibilityOf(incrementButton.get(4)));
		wait.until(ExpectedConditions.visibilityOf(TicketClass.get(0)));
		TicketClass.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(TicketClassEconomy.get(0)));
		TicketClassEconomy.get(0).click();
		
		wait.until(ExpectedConditions.visibilityOf(fromName.get(0)));
		fromName.get(0).click();
		fromNameBox.get(0).clear();
		fromNameBox.get(0).sendKeys(OriginCode );
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-apicode,'"+OriginCode+"')]")));
		List<WebElement> webElementapiCodeFrom =driver.findElements(By.xpath("//li[contains(@data-apicode,'"+OriginCode+"')]"));
		webElementapiCodeFrom.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(ToNameBox.get(0)));
		ToNameBox.get(0).clear();
		ToNameBox.get(0).sendKeys(DestinationCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@data-apicode,'"+DestinationCode+"')]")));
		 List<WebElement> webElementapiCodeTo =driver.findElements(By.xpath("//li[contains(@data-apicode,'"+DestinationCode+"')]"));
		//List<WebElement> webElementapiCodeFrom =driver.findElements(By.xpath("//li[@data-apicode='"+Origincode+"']"));
		webElementapiCodeTo.get(0).click();
		FromCalendar.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(FromDate.get(0)));
		FromDate.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(ToDate.get(0)));
		//homePage.ToCalendar.get(0).click();
		ToDate.get(0).click();
		driver.get("https://www.expedia.ca/Flights-Search?flight-type=on&starDate=20%2F12%2F2018&endDate=12%2F06%2F2019&mode=search&trip=roundtrip&leg1=from%3AToronto%2C+ON%2C+Canada+%28YYZ-Pearson+Intl.%29%2Cto%3ADelhi%2C+India+%28DEL-Indira+Gandhi+Intl.%29%2Cdeparture%3A20%2F12%2F2018TANYT&leg2=from%3ADelhi%2C+India+%28DEL-Indira+Gandhi+Intl.%29%2Cto%3AToronto%2C+ON%2C+Canada+%28YYZ-Pearson+Intl.%29%2Cdeparture%3A12%2F06%2F2019TANYT&passengers=children%3A0%2Cadults%3A1%2Cseniors%3A0%2Cinfantinlap%3AY");     //homePage.searchButton.click(); 
	
		
	}
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	

}
