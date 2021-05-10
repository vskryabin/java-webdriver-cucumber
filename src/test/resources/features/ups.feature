@ups_object
Feature: Ups Test Suite

  @ups_object1
  Scenario: Create shipment
    Given  I go to the "ups" page
    When I select "United States - English" as a region
    When I go to the shipment page
    And  create a new shipment
    When I fill out country "United States" name "Andrei Travkin" email "andreytravkin5@gmail.com" and phone "5105892769"
    And I fill out address as "5801 Preston Oaks Road, 1012", zipCode "75254" city "Dallas" state as "Texas"
    When I submit the form
    Then I verify that data address is "5801 Preston Oaks Road, 1012, DALLAS, TX 75254"
    When I cancel the form
    Then I verify that form resets

  @ups_object2
  Scenario: UPS end to end
    Given  I go to the "ups" page
    When I select "United States - English" as a region
    When I go to the shipment page
    And  create a new shipment
    When I fill out country "United States" name "Andrei Travkin" email "andreytravkin5@gmail.com" and phone "5105892769"
    And I fill out address as "5801 Preston Oaks Road, 1012", zipCode "75254" city "Dallas" state as "Texas"
    When I submit the form
    Then I verify that data address is "5801 Preston Oaks Road, 1012, DALLAS, TX 75254"
    When I fill out destination shipment fields
    Then I verify total charges appear
    When I submit the shipment form
    And I set packaging type
    Then I verify total charges changed
    When I submit the shipment form
    And I select cheapest delivery option
    And I submit the shipment form
    And I set Saturday Delivery type
    Then I verify total charges changed
    When I submit the shipment form
    And I select Paypal payment type
    And I submit the shipment form
    Then I review all recorded details on the review page
    And I cancel the shipment form Then I verify shipment form is reset
