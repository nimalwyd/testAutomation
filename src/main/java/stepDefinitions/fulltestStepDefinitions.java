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

package stepDefinitions;
import java.io.IOException;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class fulltestStepDefinitions extends TestBase {
	
HomePage homepage;
@Before
public void setUp()
{

	System.out.println("initial setup..");
	
}

@After
public void tearDown()
{
	driver.close();
	
}


@Given("^home page is loaded with \"(.*)\" and \"(.*)\"$")	
public void HomePageisLoaded(String fromPlacename, String toPlacename) throws IOException, InterruptedException
	{
	
	initialization();
	homepage = new HomePage();
	Thread.sleep(1000);
	homepage.selectBasicsOfJourney();
	homepage.SelectOriginAndDestination(fromPlacename, toPlacename);
	}
	
@When("^homepage title is verified$")
public void homepage_title_is_verified() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^round trip journey is selected$")
public void round_trip_journey_is_selected() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^one adult is selected$")
public void one_adult_is_selected() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^economy is selected$")
public void economy_is_selected()  {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^origin is entered as YYZ$")
public void origin_is_entered_as_YYZ() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^destination is entered as BLR$")
public void destination_is_entered_as_BLR()  {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^departure date is selcted$")
public void departure_date_is_selcted() {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^Arrival date is selected$")
public void arrival_date_is_selected()  {
    // Write code here that turns the phrase above into concrete actions
}

@Then("^Search button is clicked$")
public void search_button_is_clicked() {
    // Write code here that turns the phrase above into concrete actions
}
}
