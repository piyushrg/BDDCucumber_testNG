
Feature: Opencart main page validations.

  @opencart
  Scenario Outline: Validate Login in open cart
    Given User launches "<URL>"
    Then user validates the title of the page
    When user clicks on "MyAccount" on "opencart_Mainpage" page
    And user clicks on "Login" on "opencart_Mainpage" page
    Then user enters "<email>" in element "Email" on "opencart_Mainpage" page
    Then user enters "<password>" in element "Password" on "opencart_Mainpage" page
    And user clicks on "LoginButton" on "opencart_Mainpage" page

    Examples:
      |URL|email|password|
      |https://demo.opencart.com|piyushrajgupta@outlook.com|Piyush@1988|