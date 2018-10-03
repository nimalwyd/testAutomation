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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class FlightSelectionConfirmationPage  extends TestBase{
	
	@FindBy(xpath = "//button[@data-content-ref='#toggle1']//span[@id='totalPriceForPassenger1']")
	public
	WebElement FramePriceBox;
	
	@FindBy(xpath = "//form[@class='continueBookingForm']//button[@id='bookButton']")
	public
	WebElement continueBooking;

	public void executeFlightSelectionConfirmationPage() throws InterruptedException
	{
		 driver.close();

			for(String winHandle : driver.getWindowHandles()){
			     driver.switchTo().window(winHandle);
			 }
		/*Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		driver.close();*/

		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("Expedia"));
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(FramePriceBox));
		FramePriceBox.click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(continueBooking));
		 continueBooking.click();
	}
	
	public FlightSelectionConfirmationPage() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}
