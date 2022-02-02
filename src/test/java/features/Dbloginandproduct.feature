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
Feature: Db login product form

  @tag1
  Scenario: Checking the functianality of Login form and product cart
    Given user must be on homepage clicking url "https://demoblaze.com/"
    
    When Click on login element
    And user should login with the same <username> and <password> as signup account
    And click on login button
    And user must be on his or her account
   	And Click on Laptops tab element
    And Click on any product
    And Click on Add to Cart and handle the alert
    
   Then Navigate to on Cart page
    And Verify if the produdct is added to cart
    
Examples:
| username | password |
| vikram1501 | markiv0115 |
