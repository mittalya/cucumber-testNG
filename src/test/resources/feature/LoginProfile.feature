Feature: Login Profile
Background: User navigates to HIA home page

Scenario: Successful login

Given I am on the HIA login page on URL
When I fill in Username with username and password
Then I click on the Log In button