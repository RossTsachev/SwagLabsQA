Feature:Login

@Sanity
Scenario: User logs in
  Given user is on home page
  When user provides valid credentials
  And clicks on the login button
  Then user is logged in to the site
  And the product list page is displayed