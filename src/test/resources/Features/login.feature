Feature: Login

  Scenario: Login using Valid User

    Given User launches the application
    When User logs in using "ValidUser"
    Then User should navigate to Home page

  Scenario: Product "Sauce Labs Backpack" is visible after login

    Given User launches the application
    When User logs in using "ValidUser"
    And Product "Sauce Labs Backpack" should be displayed

  Scenario: Product "Sauce Labs Bike Light" is visible after login

    Given User launches the application
    When User logs in using "ValidUser"
    And Product "Sauce Labs Bike Light" should be displayed

  Scenario: Product "Sauce Labs Bolt T-Shirt" is visible after login

    Given User launches the application
    When User logs in using "ValidUser"
    And Product "Sauce Labs Bolt T-Shirt" should be displayed

  Scenario: Product "Sauce Labs Fleece Jacket" is visible after login

    Given User launches the application
    When User logs in using "ValidUser"
    And Product "Sauce Labs Fleece Jacket" should be displayed

  Scenario: Product "Sauce Labs Onesie" is visible after login

    Given User launches the application
    When User logs in using "ValidUser"
    And Product "Sauce Labs Onesie" should be displayed

  Scenario: Product "Test.allTheThings() T-Shirt (Red)" is visible after login

    Given User launches the application
    When User logs in using "ValidUser"
    And Product "Test.allTheThings() T-Shirt (Red)" should be displayed

  Scenario: Locked out user sees login error

    Given User launches the application
    When User logs in using "LockedUser"
    Then User should see login error

  Scenario: Invalid user sees login error

    Given User launches the application
    When User logs in using "InvalidUser"
    Then User should see login error

  Scenario: Problem user sees login error

    Given User launches the application
    When User logs in using "ProblemUser"
    Then User should see login error
