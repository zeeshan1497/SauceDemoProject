Feature: Login and then Purchase a product from saucedemo

Scenario Outline: Verify login is successful with valid credentials

Given user is on login page
When user enters the valid <username> and <password> and clicks login button
Then the user should be logged in successfully on <appName>

Examples:
| username | password | appName |
| standard_user | secret_sauce | Swag Labs |


Scenario Outline: Verify order is created successfully

Given user adds a <prodName> into cart
When user checkouts from cart
And user submits the cart by inputting <fname> , <lname> and <pcode> in checkout form
Then <successMsg> message is displayed on Confirmation page

Examples:
| pageName	| prodName 				| fname 	| lname 	| pcode  |
| Products	| Sauce Labs Backpack 	| zeeshan 	| ismail 	| 12345  |
