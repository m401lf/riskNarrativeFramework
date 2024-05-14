@002TC
#@all
Feature: Financial Services - Functionality
  As a user
  I want to be able to search for jobs
  So that I can find the right job

  Background: Common steps
    Given I landed on a home page "https://risk.lexisnexis.co.uk/"
    And I should see the cookie banner
    And I click on Accept all Cookies button
    And I should not see the cookie banner
    And logo is displayed
    When I click "About Us" link
    And I should see "About Us" and 8 other links
    And I should see About Us page links as follows:
      | Business Overview        |
      | Executive Leadership     |
      | Our Technology           |
      | Careers                  |
      | Press Room               |
      | Experts                  |
      | Corporate Responsibility |
      | Diversity & Inclusion    |
    And click on "Careers" link
    And I tap on "Search jobs"

  Scenario: 01 - should display No Result
    When I search for job with a job title "automation-tester"
    Then I can see the search result count as "No Results"
    And I close browser

  Scenario Outline: 02 - should be showing at least 1 search results
    When I search for job with a job title "<Job Title>"
    Then I can see the job search result count displayed in the page is greater than <Least Expected Job Count>
    And I should see Text for many items "<Job Title>"
    And I close browser
    Examples:
      | Job Title         | Least Expected Job Count |
      | automation tester | 0                        |

  @002-TC-03
  Scenario Outline: 03 - search results should be related to the job title
    When I search for job with a job title "<Job Title>"
    And I can see the job search result count displayed in the page is greater than <Least Expected Job Count>
    And I should see Text for many items "<Job Title>"
    Then I can see search results related to the "<Job Title>"
    And I close browser
    Examples:
      | Job Title         | Least Expected Job Count |
      | Software Engineer | 0                        |

  Scenario Outline: 04 - search results not relevant to the job title
    When I search for job with a job title "<Job Title>"
    And I can see the job search result count displayed in the page is greater than <Least Expected Job Count>
    And I should see Text for many items "<Job Title>"
    Then I can see search results not related to the "<Job Title>"
    And I close browser
    Examples:
      | Job Title  | Least Expected Job Count |
      | autonation | 0                        |