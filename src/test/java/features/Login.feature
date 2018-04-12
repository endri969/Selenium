Feature: Login to phptravel

  Scenario:Login scenario test for phptravel
    Given I navigate to the phptravel page
    Then I click the singin link
    And I enter email as "user@phptravels.com" and password as "demouser"
    Then the user account should be displayed

