@employee
Feature: Employee
  In order to manage the employee details
  As an admin
  I want to add,edit,delete employee records

  @addemployee
  Scenario Outline: Add Valid Employee
    Given I have browser with OrangeHRM application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    And I click on PIM menu
    And I click on Add Employee
    And I fill the new employee form
      | firstname | middlename | lastname |
      | <fname>   | <mname>    | <lname>  |
    And I click on Save
    Then I should get the profile name as '<expected_name>'
    And I should get firstname in the field '<expected_first_name>'

    Examples: 
      | username | password | fname | mname | lname | expected_name | expected_first_name |
      | Admin    | admin123 | john  | w     | wick  | john wick     | john                |
      | Admin    | admin123 | ken   | v     | kevin | ken kevin     | ken                 |
