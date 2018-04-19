Feature: Register automationpractice

  Scenario: I register an account to the page
    Given I navigate to the automation practice
    Then I navigate to register for the first time
    And I enter email as "asdasd@gmail.com"
    Then I enter the necessary information to create an account
      | Value                  | Fields                     |
      | Title                  | Mr.                        |
      | First Name             | TestName                   |
      | Last Name              | TestSurname                |
      | Password               | demotest                   |
      | Date of Birth          | 12-2-1991                  |
      | Company                | TestCompany                |
      | Address                | Test Street                |
      | City                   | Tirane                     |
      | State                  | Alabama                    |
      | Zip                    | 36310                      |
      | Additional Information | Hello there this is a test |
      | Mobile Phone           | 00355696969696             |
    And The register should be successful










