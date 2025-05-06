Feature: ShoppingCart

  @Regression
  Scenario: User adds item to shopping cart
    Given user has logged into the site
    When user adds item to shopping cart
    And user goes to shopping cart page
    Then user can see the item in the shopping cart