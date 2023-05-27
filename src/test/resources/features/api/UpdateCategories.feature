@API_Mert
Feature: Update Categories Testing

  Scenario Outline: API Testing
    Given User checks the endpoint
    When User sents PUT request to the server to update a category with <id> and '<name>'
    Then User validates the status code 200
    And User should get the category with <id> and '<name>'

    Examples:
      | id | name       |
      | 5  | Medicine1  |
      | 2  | MEDICINE2  |
      | 1  | medicine3  |
      | 2  | medicine4  |
      | 9 | medicine5 |

    Scenario: Negative Status Code Testing
      Given User checks the endpoint
      When User sends a PUT request to the server to update a category with id 9999 and an empty name ''
      Then User validates the status code is 400