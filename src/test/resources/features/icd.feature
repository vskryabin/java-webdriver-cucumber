@icd_feature
Feature: ICD smoke test

  @icd_feature1
  Scenario: Test request demo form
  Given I navigate to the "icd" page
    When I accept the cookies
    When I go to request demo page
    When I fill out "First Name" field with "Jack"
    When I fill out "Last Name" field with "Sparrow"
    #    fill out the Title
    When I fill out "Email" field with the "JackSparrow"
    When I fill out "Company" field with "Pirates Inc"
    When I fill out "Comments" field text "Captain Jack Sparrow"
    When I acknowledge terms and conditions
    When i submit the form
    Then I verify form was submitted


  @icd_feature2
  Scenario: verify demo form error messages
    Given I navigate to the "icd" page
    When I accept the cookies
    When I go to request demo page
    When i submit the form
    Then I verify that message "There was a problem with your submission" is present
    Then I verify that first name error message equal to "This field is required"
    Then I verify that last name error message equal to "This field is required"
    Then I verify that email error message equal to "This field is required"
    Then I verify that company error message equal to "This field is required"
    When I fill out "Email" field with the "@JackSparrow"
    When i submit the form
    When I go to terms and conditions page
    Then I verify that title contains "Terms & Conditions"
    When I go to privacy policy page
    Then I assert that message "Consent to this Privacy Policy and the use of personal data" is present
    When I go back to request demo page
    Then I verify that email error message equal to "The email address entered is invalid"


  @icd_feature3
  Scenario: End to end test (not really)
    Given I navigate to the "icd" page
    When I accept the cookies
    When I go to investing page
    Then I verify that header "Investment products" is present
    When I go to Money market funds page
    Then I verify that "Japanese Yen" is among listed currencies
    When I go back to investing page
    When I go to "Commercial paper" page
    Then I verify that "Toyota commercial paper" is present
    When I go to "Resources" page
    When I click subscribe for email
    Then I verify that "here was a problem with your submission" error is present
    When I enter email "SparrowJack@gmail.com"
    When I click subscribe for email
    Then I verify that "Thank you for signing up for the ICD Newsletter!" message is present