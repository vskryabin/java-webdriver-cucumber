@sample_page
Feature: Training

  @sample1
  Scenario: Validate error messages
    Given I go to the "sample" page
    When I click submit button
    Then I verify username error text is "This field is required."
    Then I verify email error text is "This field is required."
    Then I verify password error text is "This field is required."
    Then I verify name error text is "This field is required."
    Then I verify Privacy Policy error text is "- Must check!"

  @sample2
  Scenario: Validate Email field behavior
    Given I go to the "sample" page
    When I send text "andrey@@gmail.com" into "email" field
    When I click submit button
    Then I verify email error text is "Please enter a valid email address."


  @sample3
  Scenario: Fill out and validate “Password” set of fields
    Given I go to the "sample" page
    Then I verify that confirmPassword field is disabled
    When I enter "123" in password field
    Then I verify password error text is "Please enter at least 5 characters."

  @sample4
  Scenario: Validate responsive UI behavior
    Given I go to the "sample" page
    When I change resolution to "Desktop" layout
    Then I verify that location date and time present
    When I change resolution to "Tablet" layout
    Then I verify that location date and time present
    When I change resolution to "Phone" layout
    Then I verify that location date and time not present

    @sample5
    Scenario: Fill out and validate all fields
      Given I go to the "sample" page
      When I fill out Username field with "Langmoore"
      When I send text "andrey@gmail.com" into "email" field
      When I enter "security" in password field
      When I enter "security" in confirm password field
      When I fill out phone field with "5105892769"
      When I fill out the name with "Andrei" "The Batya" "Travkin"
      When I select Gender "male"
      When I fill out address with "5801 Preston Oaks Rd, apt 1012, Dallas, TX, 75254"
      When I select country as "Russia"
      When I select car make as "Toyota" and "Other"
      When I check allowed to contact me
      When I set DOB as "08/31/1992"
      When I accept third party agreement
      When I fill out additional info with name "Hikaru" and phone "3473444549"
      When I click related documents
      Then I verify that page contains "Documents List"
      When I upload file "gitCommands.txt"
      Then I verify that name of the uploaded file is "gitCommands.txt"
      When I agree to privacy policy
      When I click submit button

      Then I verify name as "Langmoore"
      Then I verify email as "andrey@gmail.com"
      Then I verify that password is entered
      Then I verify phone number is "5105892769"
      Then I verify the name is "Andrei The Batya Travkin"
      Then I verify that gender is certainly "male"
      Then I verify the address "5801 Preston Oaks Rd, apt 1012, Dallas, TX, 75254"
      Then I verify that country is "Russia"
      Then I verify that car make is "Toyota, Other"
      Then I verify that allowed to contact is "true"
      Then I verify date of birth "08/31/1992"
      Then I verify third party agreement is "accepted"
      Then I verify Contact Person Name is "Hikaru"
      Then I verify Contact Person phone is "3473444549"
      Then I verify uploaded file is "gitCommands.txt"
      Then I verify that agreed to privacy policy is "true"
      Then I verify current date
      When I hit return button
      Then I verify that submit button is present






