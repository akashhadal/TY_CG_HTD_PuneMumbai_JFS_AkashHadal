Feature: Testing the user signin feature

Scenario: Testing the sign in feature with valid data
Given the user has loaded the application in the browser
When the user clicks on sign in link
When the user enters the valid email
And the user enters the valid password
And the user clicks on the sign in button
Then the booking page must be displayed
When the user selects location from location dropdown box
And the user selects checkin date
And the user selects checkout date
And the user clicks on search button
When user clicks on book room in particular hotel
When user click on book now for selecting room type
When user clicks on cash in payment mode
When user clicks on home button on booking done page
When the user clicks on view bookings
When the user clicks on profile
