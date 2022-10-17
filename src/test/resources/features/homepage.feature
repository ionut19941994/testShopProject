Feature: Make various actions with the items in the shop

  Background: Customer navigates to the shop page
    Given that the user navigated to the Shop page
  @test
  Scenario: Make various actions on the website
    Given I add four random items to my cart
    When I view my cart
    Then I find the total four items listed in my cart
    When I search for lowest price item
    And I am able to remove the lowest price item from my cart
    Then I am able to verify three items in my cart