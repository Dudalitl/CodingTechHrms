#Author: kasim
Feature: Adding employee skills

  Background: 
    Given user is logged with valid admin credentials
    And user navigate to employee list page

	@smoke
  Scenario: Admin modify employee details
    When user enters valid employee id "14289"
    And click on search button
    And user see employee info of "14289" is displayed
    And user can click employee id on the table and display details
