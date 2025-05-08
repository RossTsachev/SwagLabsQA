Feature:Login

  @Sanity
  Scenario: User logs in with valid credentials
    Given user is on home page
    When user logs in with valid credentials
    Then user is logged in to the site
    And the product list page is displayed

  @Sanity
  Scenario Outline: User tries to login with invalid credentials
    Given user is on home page
    When user tries to log in with invalid <username> and <password>
    Then the url stays the same
    And the input fields are highlighted in red
    And an error message is displayed

    Examples:
      | username      | password       |
      | standard_user | wrong_password |
      | wrong_user    | secret_sauce   |
    