@QA_Regression_1
  Feature: Add to cart Functionality
    Scenario: user should be able to add products into cart
      Given user provides username 'yaseminnn12' password '123456'
      When user clicks Add to cart button
      Then user validates check mark on that blue button