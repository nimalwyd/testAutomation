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

package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	public static int totalTestCases;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\nimal\\eclipse-workspace\\AutomationNimal\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		totalTestCases = sheet.getLastRowNum();
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		//sheet.getRow(0).getLastCellNum());
		for ( int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
				
			}
			
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	public static void senddata(WebDriver driver, WebElement element, int timeunit, String value)
	{
		
		element.clear();
		new WebDriverWait(driver, timeunit).until(ExpectedConditions.visibilityOf(element));
		 element.sendKeys(value);
		 
		
	}

	public static void clickOn(WebDriver driver, WebElement element, int timeunit)
	{
		
		
		new WebDriverWait(driver, timeunit).until(ExpectedConditions.visibilityOf(element));
		 element.click();
		
	}
	

}
