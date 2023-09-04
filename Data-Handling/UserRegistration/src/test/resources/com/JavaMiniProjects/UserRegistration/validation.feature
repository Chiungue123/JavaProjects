#Author: example.gmail.com
#Keywords: name, email, age, status
#Description: To validate the functionality that checks the user inputs

@tag
Feature: User Validation

  @tag1
  Scenario Outline: Registration Test Values
    Given I enter the values <name>, <email> and <age> 
    When I press enter 
    Then The program validation will return a <string>

    Examples: 
      | name  | email  |  age  | status  |
      | name1 | email1 |   1   | success |
      | name2 |   1    |   5   |  fail   |
      |   5   | email2 |   4   |  fail   |
      | user  | email5 |   0   |  fail   |
