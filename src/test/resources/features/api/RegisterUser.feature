@API_Amina
Feature: Register functionality
  Scenario: Register regular user
    Given user has codefish endpoint
    When user sends POST request to register regular user 'ROLE_USER', validates username 'aminadrv1' and role, status code is 201

