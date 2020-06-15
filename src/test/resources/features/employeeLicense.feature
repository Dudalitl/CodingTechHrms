#Author: Yuri
Feature: Title of your feature
@test
  Scenario: Title of your scenario
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "14289"
    And click on search button
    And user see employee info of "14289" is displayed
    And user can click employee id on the table and display details
    Then user navigate to Qualifications
    And user click button Add at License
    And user chooses License Type "Permissive licenses"
    And user add License number "H2-74YRN-8429L"
    And user add Issued Date "2019-Jun-10"
    And user add Expiry Date "2022-Jun-10"
    And user click button save
    And user check license "Permissive licenses" is added
