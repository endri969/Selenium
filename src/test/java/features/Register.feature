Feature: Register automationpractice

  Scenario: I register an account to the page
    Given I navigate to the automation practice
    Then I navigate to register for the first time
    And I enter email as "enditest@gmail.com"
    Then I enter the necessary information to create an account
      | Value                  | Fields                     |
      | Title                  | Mr.                        |
      | First Name             | Endri                      |
      | Last Name              | Zylali                     |
      | Password               | demotest                   |
      | Date of Birth          | 19-6-1991                  |
      | Company                | AMD                        |
      | Address                | Blvd. Bajram Curri         |
      | City                   | Tirane                     |
      | State                  | Alabama                    |
      | Zip                    | 36310                      |
      | Additional Information | Hello there this is a test |
      | Mobile Phone           | 0355695664446              |
    And The register should be successful





