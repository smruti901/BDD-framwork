Feature: Login

Scenario: Successful Login with VAlid Credentials
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And User enters Email as "admin@yourstore.com" and Password "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And Close browser
	
	Scenario Outline: Login Data Driven
	Given User Launch Chrome Browser
	When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	And User enters Email as "<email>" and Password "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on Log out link
	Then Page Title should be "Your store. Login"
	And Close browser
	
	Examples:
		| email | password |
		|	admin@yourstore.com | admin |
		|	admin1@yourstore.com | admin123 |
	