Feature: Shopping Cart

  @Case5
  Scenario: User can increase the amount of product after adding the cart
    Given user is on the home page of the application
    When user adds any item to the cart
    And user goes to checkout page
    And user clicks the plus icon to increase amount
    Then user calculates total price and verifies it is matching with actual one

