@QA_Regression
Feature: Login Testing

  Scenario: : Happy Path Login Functionality
    Given User navigates to the website
    When User provides username and password
    Then User validates the 'Ecommerce App'

  Scenario Outline: Negative Path Login Functionality
    When User provides '<username>' and '<password>'
    Then User validates 'Authentication failed'

    Examples:
      | username | password |
      | admin    | 1234     |
      | 1234     | admin    |
      | 1234     | 1234     |





