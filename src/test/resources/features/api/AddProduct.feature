@API_Vitaliy
Feature: Add Product API Testing

  Scenario Outline: Positive API testing
    Given User has valid API endpoint
    When User sends POST request to add product with  <id>, '<name>' and <price>
    Then Status code is 200
    And User should get a product <id>, '<name>' and <price>

    Examples:
      | id  | name        | price |
      | 103 | Amlodipine  | 14 |
      | 104 | Amlodipine2 | 15 |
      | 105 | Amlodipine3 | 16 |