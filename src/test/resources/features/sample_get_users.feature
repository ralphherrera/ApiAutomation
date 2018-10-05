@SampleGetUsers
Feature: Get User Details
  As a User
  I should be able to get the list of users along with their information
  So that I can view their information

  @sampletest
  Scenario: Get All User Information
    Given I have access to the system
    When I retrieve all users in the system
    Then I should see the list of users in the system
    And the status code is '200'