Feature: API : Allow user to fetch the created bookings

  Scenario: User is trying to fetch the created bookings
    When User enters valid details to create a booking
      | firstname | lastname | additionalneeds | totalprice | depositpaid |
      | Rohit     | Sharma   | Breakfast       | 7000       | true        |
    When User enters booking date details to create a booking
      | checkin    | checkout   |
      | 2018-01-01 | 2018-01-04 |
    And User makes a request to create a booking
    Then User should be able to create a booking successfully
    When User stores the booking id to fetch the created bookings
    When User makes a request to fetch the created bookings
    Then User should be able to fetch the created bookings
