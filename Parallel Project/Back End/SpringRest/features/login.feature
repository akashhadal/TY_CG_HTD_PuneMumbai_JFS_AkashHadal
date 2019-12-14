Feature:  Testing the User login Feature


Scenario: Testing the User login Feature with Valid Data
Given the user has loaded the application in the browser
When the user clicks on the login Button on navbar
When the user enters the useremail in the username textbox
And the user enters the  password in the password textbox
And the user clicks on the login Button
Then the dashboard pages must be loaded