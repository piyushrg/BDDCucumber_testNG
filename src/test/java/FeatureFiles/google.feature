@test
Feature: Google Functionality


  Scenario Outline: Google search
    Given User launches "<URL>"
    Then user "search" on "googleSearchpage" page
    And user clicks on "news" on "googleSearchpage" page
    And user stores all the "headlines" on "googleSearchpage" page in report

    Examples:
      |URL|
      |https://www.google.com|


    Scenario Outline: Google News
      Given User launches "<URL>"
      And user clicks on "NewsRegion" on "googleNews" page
      And user stores all the "headlines" on "googleNews" page in report
      Examples:
        |URL|
        |https://news.google.com|

