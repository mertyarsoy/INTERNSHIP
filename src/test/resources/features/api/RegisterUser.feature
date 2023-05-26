@QA_AMINA_Regression
Feature: Register functionality
  Scenario: Register regular user
    Given user has codefish endpoint
    When user sends POST request to register regular user and status code is 200
    Then user sends GET request and status code is 200
    Then user validates registered regular user
