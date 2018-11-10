@FunctionalTest
Feature: flight portal full test

##########APPROACH################
#    Create only one step definition file which has the step definitons for all feature file steps
#    in each feature file, ad the required steps which needs to be done to reach that page  is added in Bakground section,
#    it only requires copy pasting steps from other feature files as there is only one step definition file.


# without example keyword 
#  Scenario:
#    Given home page is loaded with "YYZ" and "BLR"
#    When homepage title is verified
#    Then round trip journey is selected
#    Then one adult is selected
#    Then economy is selected
#    Then origin is entered as YYZ
#    Then destination is entered as BLR
#    Then departure date is selcted
#    Then Arrival date is selected
#    And Search button is clicked
   

#Description: The purpose of this feature is to test the Background keyword
 
#Background: User is Logged In
#	Given I navigate to the login page
#	When I submit username and password
#	Then I should be logged in   


# with example keyword
@SmokeTest  @RegresstionTest @End2End
Scenario Outline:
    Given home page is loaded with "<origin>" and "<destination>"
    When homepage title is verified
    Then round trip journey is selected
    Then one adult is selected
    Then economy is selected
    Then origin is entered as YYZ
    Then destination is entered as BLR
    Then departure date is selcted
    Then Arrival date is selected
    And Search button is clicked
Examples:
  			| origin  | destination  |
  			| YYZ	   |  BLR        |
  			| MEL	   |  YYZ        |
  			