@QA_VITALY_Regression
  Feature: Testing Products List
    Scenario: Testing that all products must be present and listed on home page
      Given user provides username and password
      Then  user validates 9 products are listed along with description and price
      And user validates cart button is working properly and expected amount of names is 9
