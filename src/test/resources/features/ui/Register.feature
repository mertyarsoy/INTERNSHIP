@QA_YASEMIN_Regression
Feature: Registration Functionality Testing

  Scenario: Positive Testing for registration
    When User provides 'yaseminnn123mama' and '123456' for registration
    Then User should be registered and Username should be shown


    Scenario: Negative Testing for registration
      When User provides the already created username 'yaseminnn123mama' and password
      Then User gets the 'Username already taken' error message
