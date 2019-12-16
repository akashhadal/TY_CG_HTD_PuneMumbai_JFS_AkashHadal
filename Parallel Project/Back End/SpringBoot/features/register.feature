Feature:  Testing the Register Feature


Scenario: Testing the Register Feature with Valid Data
Given the user has loaded the application in the browser
When the user clicks on register Button on Navbar
When the user enters the userid in the username textbox
And the user enters the username in the username textbox
And the user enters the useremail in the useremail textbox
And the user enters the  password in the password textbox
And the user selects the  role in the role dropdown
And the user clicks on the register Button
Then the dashboard pages must be loaded