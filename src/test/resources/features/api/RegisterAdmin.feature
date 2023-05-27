@QA_regression-4
Feature: Register functionality
  Scenario: Register admin user
    When user has codefish endpoint
    Then user sends POST request to register admin user and status code is 201