#Author: Yuri
Feature: add different licenses in qualifications



  Scenario: add different licenses in qualifications
    Given user is logged with valid admin credentials
    When user navigate to Licenses
    And user click button add
    And user add Licenses "Permissive licenses"
    And user click save button
    Then user check license "Permissive licenses" is displayed
