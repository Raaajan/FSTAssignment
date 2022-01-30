#Author: Rajan Dubey
#Assignment : Full Stack Tester
Feature: Shopping on saucedemo website

  @scenario1
  Scenario Outline: To verify adding multiple options in cart and checkout
    Given user is on saucedemo homepage
    And user logged in using correct credential
      | username      | password     |
      | standard_user | secret_sauce |
    And user adds required item to cart
    And user proceeds to checkout
    And user enters details <FirstName> and <LastName> and <PostalCode> for checkout
    And user confirm checkout
    Then user verify final confirmation message

    Examples: 
      | FirstName | LastName | PostalCode |
      | abc       | def      |     400087 |

  @scenario2
  Scenario Outline: To verify adding removing then adding and checkout
    Given user is on saucedemo homepage
    And user logged in using correct credential
      | username      | password     |
      | standard_user | secret_sauce |
    And user adds one item and then remove that item to go back
    And user adds required item to cart
    And user proceeds to checkout
    And user enters details <FirstName> and <LastName> and <PostalCode> for checkout
    And user confirm checkout
    Then user verify final confirmation message

    Examples: 
      | FirstName | LastName | PostalCode |
      | abc       | def      |     400087 |

  @scenario3
  Scenario Outline: To verify sort low to high
    Given user is on saucedemo homepage
    And user logged in using correct credential
      | username      | password     |
      | standard_user | secret_sauce |
    And user sorts item low to high
    And user adds required item to cart
    And user proceeds to checkout
    And user enters details <FirstName> and <LastName> and <PostalCode> for checkout
    And user confirm checkout
    Then user verify final confirmation message

    Examples: 
      | FirstName | LastName | PostalCode |
      | abc       | def      |     400087 |
