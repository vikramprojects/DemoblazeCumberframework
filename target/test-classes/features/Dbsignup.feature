#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Signup form
  

  @tag1
  Scenario: Checking Functionality of Signup form
    Given user must be on homepage by clicking url "https://demoblaze.com/"
   When Click on signup element
   And Enter <username> and <password>
    And Click on signup button, also handle alert
   
    Then user must be on the website page

 
    Examples: 
      |username|password|
      |vikram199|markiv198|