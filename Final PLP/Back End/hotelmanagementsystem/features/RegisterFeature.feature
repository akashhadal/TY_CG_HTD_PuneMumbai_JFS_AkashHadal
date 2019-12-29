Feature: Testing the user sign up feature

Scenario: Testing the sign up feature with valid data
Given the online user has loaded the application in the browser
When the user clicks on sign up link
And the user enters the valid user name
And the user enters the valid user email
And the user enters the valid user password
And the user selects the valid nationality from dropdown box
And the user enters the valid address
And the user enters the valid phone no
And the user clicks on the sign up button
Then the sign in page must be displayed