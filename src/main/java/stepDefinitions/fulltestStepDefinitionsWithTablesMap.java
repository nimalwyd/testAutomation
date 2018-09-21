package stepDefinitions;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class fulltestStepDefinitionsWithTablesMap {
// DataTable with Maps	
WebDriver driver;
//Global hooks
@Before(order=1)
public void setUp()
{

	System.out.println("initial setup..");
	
}


//Global hooks
@After(order=1)
public void tearDown()
{
	System.out.println("final  setup..");

	
}

@Before("@scenarioOne")  //local hook, only for first scenario
public void setUpScenarioOne()
{

	System.out.println("initialising  scenarioOne..");
	
}
//Global hooks
@Before(order=0)
public void setUp1()
{

	System.out.println("initial setup..");
	
}


//Global hooks
@After(order=0)
public void tearDown1()
{
	System.out.println("final  setup..");

	
}

	
	@Given("^home page is loaded with origin and destination_ok$")
	public void home_page_is_loaded_with_origin_and_destination_ok(DataTable arg1) throws InterruptedException  {
		for( Map<String,String> data:  arg1.asMaps(String.class, String.class)) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nimal\\eclipse-workspace\\NimalAutomationFramework\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://www.ca.kayak.com/flights");
		Thread.sleep(1000);
		List<WebElement> fromPlace = driver.findElements(By.xpath("//*[contains(@id,'-origin-airport-display-inner')]"));
		fromPlace.get(0).click();
		Thread.sleep(1000);

		List<WebElement> fromPlaceTextBox = driver.findElements(By.xpath("//*[contains(@id,'-origin-airport-smarty-wrapper')]//*[contains(@id,'-origin-airport')]"));
		fromPlaceTextBox.get(0).sendKeys(data.get("origin")); //0th row 0th column		
		
		}
	}


@When("^homepage title is verified ok$")
public void homepage_title_is_verified_ok()  {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^round trip journey is selected ok$")
public void round_trip_journey_is_selected_ok()  {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^one adult is selected ok$")
public void one_adult_is_selected_ok()  {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^economy is selected ok$")
public void economy_is_selected_ok()  {
    // Write code here that turns the phrase above into concrete actions
   
}

@Then("^origin is entered as YYZ ok$")
public void origin_is_entered_as_YYZ_ok() {
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^destination is entered as BLR ok$")
public void destination_is_entered_as_BLR_ok(){
    // Write code here that turns the phrase above into concrete actions
    
}

@Then("^departure date is selcted ok$")
public void departure_date_is_selcted_ok() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^Arrival date is selected ok$")
public void arrival_date_is_selected_ok() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^Search button is clicked ok$")
public void search_button_is_clicked_ok() {
    // Write code here that turns the phrase above into concrete actions
}


}
