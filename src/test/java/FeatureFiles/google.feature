Feature: Google Functionality

  @test
  Scenario Outline: Google search
    Given User launches "<URL>"
    Then User search on google page

    Examples:
      |URL|
      |https://www.google.com|