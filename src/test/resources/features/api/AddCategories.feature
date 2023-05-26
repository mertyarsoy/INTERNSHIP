@API_Regression
@API_Yasemin
Feature: Add Categories API Testing

  Scenario Outline: Positive API Testing
    Given Categories are available on the server
    When I sent post API request to server to add a category with <id> and '<name>'
    Then The status code should be 200
    And I should get the category with <id> and '<name>'

    Examples:
      | id | name      |
      | 6  | Medicine1 |
      | 7  | Medicine2 |
      | 8  | Medicine3 |

