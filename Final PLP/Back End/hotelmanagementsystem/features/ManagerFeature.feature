Feature: Testing the manager signin feature

Scenario: Testing the sign in feature with valid data
Given the manager has loaded the application in the browser
When the manager clicks on sign in link
When the manager enters the valid email
And the manager enters the valid password
And the manager clicks on the sign in button
Then the manager page must be displayed
When the manager clicks on employee counter
When the manager clicks on register manager
When the manager enters employee name
And the manager enters email
And the manager enters password
And the manager selects nationality in nationality dropdown
And the manager enters address
And the manager enters phone number
And the manager clicks on register employee button
When the manager clicks on manager link
And the manager clicks on customers counter