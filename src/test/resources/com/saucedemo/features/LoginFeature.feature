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

  @Regression
  Scenario: User logs in using only keyboard
    Given user is on home page
    When user presses Tab key
    Then the username field becomes active
    When user enters valid username
    And user presses Tab key
    Then the password field becomes active
    When user enters valid password
    And user presses Enter key
    Then user is logged in to the site
    And the product list page is displayed