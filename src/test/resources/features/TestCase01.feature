#Author:anatolytetenkin@gmail.com
Feature: Task from WW

  @smoke
  Scenario: TC01
    Given I am on a main page
    Then  I validate expected title is "WW (Weight Watchers): Weight Loss & Wellness Help"
    Given I click on find studio button
    Then  I validate title is "Find WW Studios & Meetings Near You | WW USA"
    When  I enter "10011" in to the search box
    And   I print title and distance of the first result
    And   I click on a first result and verify the title
    Then  I print TODAY Hours and Operation from current location
    And   I print numbers of meeting for each person
      | JOHN B.    |
      | DANA F.    |
      | LISA S.    |
      | LAUREN C.  |
      | ARANSAS S. |
      | CAMI B.    |
      | KENDRA V.  |
      | STEVEN H.  |
      | DIANE M.   |
      | MINDI K.   |
      | SILMARA R. |
      | ROBERT B.  |
