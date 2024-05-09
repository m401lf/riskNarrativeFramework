@003TC
@all
Feature: Display a cookie preferences banner
  As a user
  I want to see a cookie preferences banner
  So that I can accept or decline the use of cookies

  Background:
    Given I landed on a home page "https://risk.lexisnexis.co.uk/"
    And I should see the cookie banner


  Scenario: 1 -User on home page and has accepted all cookies - don’t show banner
    When I click on Accept all Cookies button
    Then I should not see the cookie banner
    And I close browser

  Scenario: 2 - Change your cookies settings - Privacy Preference Centre should be displayed
    When I click on Cookies Settings
    Then "Privacy Preference Centre" is displayed
    Then I should not see the cookie banner
    And I close browser

  Scenario: 3 -User tap Cookies setting - strictly Necessary Cookies is always Active
    When I click on Cookies Settings
    Then "Privacy Preference Centre" is displayed
    And I should see "Strictly Necessary Cookies" is "Always Active" by default
    When I click plus icon in "Strictly Necessary Cookies" from Manage Consent Preferences
    And I can see minus icon and switch nob should not be displayed in "Strictly Necessary Cookies"
    And I tap on "Confirm My Choices" button
    Then I should not see the cookie banner
    And I close browser

  Scenario: 4 -User tap Cookies setting - minus icon is displayed and switch nob should be green color
    When I click on Cookies Settings
    And "Privacy Preference Centre" is displayed
    And I should see "Strictly Necessary Cookies" is "Always Active" by default
    And I click plus icon and switch nob from category "Privacy Preference Centre"
    And I can see minus icon and switch nob turns green color in "Privacy Preference Centre"
    And I tap on "Confirm My Choices" button
    Then I should not see the cookie banner
    And I close browser

  Scenario: 5 -User tap Cookies setting - Allow All button
    When I click on Cookies Settings
    And "Privacy Preference Centre" is displayed
    And I should see "Strictly Necessary Cookies" is "Always Active" by default
    And I click plus icon and switch nob from category "Privacy Preference Centre"
    And I can see minus icon and switch nob turns green color in "Privacy Preference Centre"
    And I click Allow All Cookies button
    Then I should not see the cookie banner
    And I close browser