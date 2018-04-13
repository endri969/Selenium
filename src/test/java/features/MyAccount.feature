Feature: My account on automation practice
  Scenario: Login for automationpractice
    Given I navigate to the automationpractice page
    Then I click the sing in link
    And I enter email as "endri.zylali@gmail.com" and the password as "demotest"
    Then the user account should be displayed if the login is successful

#    Then I navigate to the order history and details
#    Then I navigate to my wishlist
#    Then I navigate to my credit slips
#    Then I navigate to my address
#    Then I navigate to my personal information

    Then I search for "dress"
    Then I sort by the price from lowest to highest
    Then I add to cart item nr "1"
    And I proceed to checkout and pay by bank


