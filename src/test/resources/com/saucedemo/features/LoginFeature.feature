Feature:Login

@Sanity
Scenario: User logs in
  Given user is on home page
  When user logs in with valid credentials
  Then user is logged in to the site
  And the product list page is displayed