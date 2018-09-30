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

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class FlightListPage extends TestBase {



	@FindBy(xpath = "//div[@data-test-id='listing-summary']//button[@data-test-id='select-button']")
	public
	 List<WebElement> selectButton;
	

	@FindBy(xpath = "//select[@id='sortDropdown']")
	public
	 List<WebElement> dropDownlist;
	
	@FindBy(xpath = "//input[@data-test-id='2+ Stops']")
	public
	 List<WebElement> twoPlusStopCheckBox;
	
	
	
	
	public void executeFlightListPage() throws InterruptedException
	{
		
		
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.titleContains("Expedia"));
	Thread.sleep(500);
	wait.until(ExpectedConditions.visibilityOf(twoPlusStopCheckBox.get(0)));
	twoPlusStopCheckBox.get(0).click();
	wait.until(ExpectedConditions.visibilityOf(dropDownlist.get(0)));
	//dropDownlist.get(0).click();
    Select priceSelect = new Select(dropDownlist.get(0));
    dropDownlist.get(0).click();
	priceSelect.selectByVisibleText("Price"+" "+"(Lowest)");

	
	
	
	
	wait.until(ExpectedConditions.visibilityOf(selectButton.get(0)));
	selectButton.get(0).click();
	Thread.sleep(1000);
	wait.until(ExpectedConditions.titleContains("Expedia"));
	wait.until(ExpectedConditions.visibilityOf(dropDownlist.get(0)));

	Set<String> handler = driver.getWindowHandles();
	Iterator<String> it = handler.iterator();
	String parentWindowId = it.next();
	String childWindowId = it.next();
	driver.switchTo().window(childWindowId);
	driver.close();
	driver.switchTo().window(parentWindowId);
	dropDownlist.get(0).click();
	priceSelect.selectByVisibleText("Price"+" "+"(Lowest)");
	
	
	
	wait.until(ExpectedConditions.visibilityOf(selectButton.get(0)));
	selectButton.get(0).click();
	
   }
    
	public FlightListPage() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

}
