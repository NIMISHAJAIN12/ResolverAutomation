Feature: Automation Work

  @Resolver
  Scenario Outline: Test first
    Given navigate to Home Page
    When checking fields
    Then enter details

  @Resolver
  Scenario Outline: Test second
    Given navigate to Home Page
    When check there are three values

  @Resolver
  Scenario Outline: Test Third
    Given navigate to Home Page
    Then check the dropdown

  @Resolver
  Scenario Outline: Test Fourth
    Given navigate to Home Page
    Then find enable and disable

  @Resolver
  Scenario Outline: Test Fifth
    Given navigate to Home Page
    Then run the tasks

  @Resolver
  Scenario Outline: Test Sixth
    Given navigate to Home Page
    Then find the method

  @Resolver
  Scenario Outline: Test Sixth part second
    Given navigate to Home Page
    Then second method
