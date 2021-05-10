@usps_object
Feature: Usps Test Suite

  @usps_object1
  Scenario: Usps Stamps
    Given I go to the "usps" page
    When I go to stamps oop
    And I sort by "Price (Low-High)" oop
    Then I verify that "Tiffany Lamp" is cheapest oop

  @usps_object2
  Scenario: Usps Boxes
    Given I go to the "usps" page
    When I go to "boxes" oop
    And I verify that media banner is present
    And I sort by "Price (Low-High)" oop
    Then I verify that "Customs Form Envelope" is present on the page

  @usps_object3
  Scenario: Usps Shoes
    Given I go to the "usps" page
    When I go to "boxes" oop
    And I search for "shoe box" in store oop
    And I sort by "Price (Low-High)" oop
    Then I verify that "OSHOEBOX" is present


  @usps_object4
  Scenario: Validate zip functionality
    Given I go to the "usps" page
    When I go to lookup zip by address
    When I fill out street as "4970 El Camino Real" city "Los Altos" state "CA"
    Then result must contain "94022" zip code

  @usps_object5
  Scenario: Validate zip functionality2
    Given I go to the "usps" page
    When I go to "Calculate a Price" page
    And I select "United Kingdom of Great Britain and Northern Ireland" with "Postcard" shape
    And I define "2" quantity
    Then I validate the cost is "$2.40"