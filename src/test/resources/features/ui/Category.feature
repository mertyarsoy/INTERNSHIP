@FAWAD_Regression
Feature: Viewing and Comparing COVID Vaccines and Other Categories
  As a user, I want to be able to view a list of available products along with their prices.

  Scenario: Display the tools with their prices in a specific Category

    When  User click the  vaccinesButton category
    And   User click the drugsButton category
    And   User click the toolsButton category
    And   User click the carsbutton category
