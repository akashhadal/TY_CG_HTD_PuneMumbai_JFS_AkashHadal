Feature:  Testing the Payment Feature


Scenario: Testing the User login Feature with Valid Data
Given the user has loaded the application in the browser
When the user clicks on the login Button on navbar
When the user enters the useremail in the username textbox
And the user enters the  password in the password textbox
And the user clicks on the login Button
When the user clicks on product list on navbar
And the user clicks on add button
When the user clicks on cart button on navbar
And the user clicks on payment button
Then the payment page must be loaded
When the user enters the name in the card Holder's Name textbox
And the user enters the card number in card nubmer textbox
And the user selects the expiry date in the month dropdown of card expiry date
And the user enters the year in the year textbox of card expiry date
And the user enters the cvv in the cvv textbox
And the user enters the address in the address textbox
And the user clicks on the submit button
Then the order history page must be loaded