Feature:  Testing the Admin Feature


Scenario: Testing the Admin Feature with Valid Data
Given the admin has loaded the application in the browser
When the admin clicks on the login Button on navbar
When the admin enters the useremail in the username textbox
And the admin enters the  password in the password textbox
And the admin clicks on the login Button
When the admin clicks on add product on navbar
When the admin enters product id in product id textbox
And the admin enters product name in product name textbox
And the admin selects category in category dropdown of product category
And the the admin enters product price in product price textbox
And the admin clicks on the submit button
When the admin clicks on product list on navbar
When the admin clicks on delete button
When the user clicks on user list button on navbar
When the user clicks on logout button on navbar 