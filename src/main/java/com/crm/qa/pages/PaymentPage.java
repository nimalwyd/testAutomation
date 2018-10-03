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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class PaymentPage extends TestBase {
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	
	
	@FindBy(xpath = "//input[@id='firstname[0]']")
	@CacheLookup
	public
	List<WebElement> firstName;
	
	@FindBy(xpath = "//input[@id='lastname[0]']")
	@CacheLookup
	public
	List<WebElement> lastName;
	 
	@FindBy(xpath = "//*[@id='country_code[0]']")
	@CacheLookup
	public
	List<WebElement> phoneCountryCode;
		
	@FindBy(xpath = "//*[@id='phone-number[0]']")
	@CacheLookup
	public
	List<WebElement> phoneNumber;
	
	@FindBy(xpath = "//*[@id='confirmation-sms-provider-checkbox']")
	@CacheLookup
	public
	List<WebElement> notificationSmsCheckBox;
	

	@FindBy(xpath = "//input[@id='gender_male[0]']")
	@CacheLookup
	public
	List<WebElement> genderCheckBoxMale;
	
	@FindBy(xpath = "//input[@id='gender_female[0]']")
	@CacheLookup
	public
	List<WebElement> genderCheckBoxFemale;
	
	@FindBy(xpath = "//select[@id='date_of_birth_year[0]']")
	@CacheLookup
	public
	List<WebElement> dobyear;
	
	@FindBy(xpath = "//select[@id='date_of_birth_day[0]']")
	@CacheLookup
	public
	List<WebElement> dobday;
	
	@FindBy(xpath = "//select[@id='date_of_birth_month0']")
	@CacheLookup
	public
	List<WebElement> dobmonth;
	
	
	
	public void executePaymentpage(String firstNameExcel, String lastNameExcel, String genderExcel,String dob) throws InterruptedException, ParseException {
		//driver.get("https://www.expedia.ca/FlightCheckout?tripid=2d28007c-adb7-4e38-9ce1-ff629791d5c4&c=dd25949c-10c2-4a3d-a54f-7651e8867b40");
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Thread.sleep(3000);;
		wait.until(ExpectedConditions.titleContains("Expedia"));
		wait.until(ExpectedConditions.visibilityOf(firstName.get(0)));
		firstName.get(0).clear();
		firstName.get(0).sendKeys(firstNameExcel);
		Thread.sleep(1000);;

		wait.until(ExpectedConditions.visibilityOf(lastName.get(0)));
		lastName.get(0).clear();
		lastName.get(0).sendKeys(lastNameExcel);
		wait.until(ExpectedConditions.visibilityOf(phoneCountryCode.get(0)));
		Select CountryCodeSelectDropDown = new Select(phoneCountryCode.get(0));
		phoneCountryCode.get(0).click();
		Thread.sleep(1000);
		CountryCodeSelectDropDown.selectByVisibleText("Canada +1");
		phoneNumber.get(0).sendKeys("4168465454");
		Thread.sleep(1000);;
		notificationSmsCheckBox.get(0).click();
		Thread.sleep(1000);
		if(genderExcel.equals("M")) {	
			genderCheckBoxMale.get(0).click();
		}
		else if(genderExcel.equals("F"))
		{
			genderCheckBoxFemale.get(0).click();

		}
		Thread.sleep(1000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		 
		Date date = formatter.parse(dob);

		// Get all the data of the date
		String strYear = (new SimpleDateFormat("yyyy")).format(date);
		String strMonth = (new SimpleDateFormat("mm")).format(date);
		String strDate = (new SimpleDateFormat("dd")).format(date);
		System.out.println(strYear);
		System.out.println(strMonth);
		System.out.println(strDate);


		Select dobYearDropDown = new Select(dobyear.get(0));
		dobyear.get(0).click();
		Thread.sleep(1000);
		dobYearDropDown.selectByVisibleText(strYear);

		Select dobmonthDropDown = new Select(dobmonth.get(0));
		dobmonth.get(0).click();
		Thread.sleep(1000);
		dobmonthDropDown.selectByValue(strMonth);
		

		Select dobDayDropDown = new Select(dobday.get(0));
		dobday.get(0).click();
		Thread.sleep(1000);
		dobDayDropDown.selectByVisibleText(strDate);
		

	
	}

}
