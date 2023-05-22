@QA_Regression_2
  Feature:Remove From Cart Functionality
    Scenario: user should be able to remove product from cart
      Given user provides username and password
      When user navigates to cart page and clicks remove button
      Then user validates 'Cart is empty' message