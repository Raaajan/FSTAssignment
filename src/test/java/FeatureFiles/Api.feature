#Author: Rajan Dubey

Feature: API Testing
Scenario: To verify simple tool rental api
Given user has base uri and initial setup
And user generate bearer token
And user get valid toolid
Then user create order for valid tool id