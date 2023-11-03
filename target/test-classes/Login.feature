@login
Feature: Login
  In order to manage the employee records
  As an admin
  I would like to access the portal

  Background: 
    Given I have browser with OrangeHRM application

  @valid @smoke
  Scenario: Valid Credentials
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    Then I should get access to dashboard with header 'Dashboard'

  @invalid
  Scenario Outline: Invalid Credentials
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    Then I should not get access to the portal with error "<expected_error>"

    Examples: 
      | username | password | expected_error      |
      | john     | john123  | Invalid credentials |
      | peter    | peter123 | Invalid credentials |
