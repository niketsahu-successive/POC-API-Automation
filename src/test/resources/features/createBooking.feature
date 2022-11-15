Feature: API : Allow user to create booking

  Scenario: User is trying to create booking with all valid details
    When User enters valid details to create a booking
      | firstname | lastname | additionalneeds | totalprice | depositpaid |
      | Rohit     | Sharma   | Breakfast       | 7000       | true        |
    When User enters booking date details to create a booking
      | checkin    | checkout   |
      | 2018-01-01 | 2018-01-04 |
    And User makes a request to create a booking
    Then User should be able to create a booking successfully

  Scenario: User is trying to create booking with all valid details while deposit is not paid
    When User enters valid details to create a booking
      | firstname | lastname | additionalneeds | totalprice | depositpaid |
      | Mohit     | Sharma   | Breakfast       | 1000       | false       |
    When User enters booking date details to create a booking
      | checkin    | checkout   |
      | 2018-01-01 | 2018-01-04 |
    And User makes a request to create a booking
    Then User should be able to create a booking successfully
