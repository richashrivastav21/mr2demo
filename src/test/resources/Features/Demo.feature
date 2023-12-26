Feature: This feature verify myntra website functionality

@MyntraDemo
Scenario: Verify when user searches for Levis then all results should contain products from brand Levis
	Given Enter Levis in search component
	When User clicks on search magnifier
	Then All results populated must contains word Levis in it

@MyntraDemo
Scenario: Verify product detail page open when user click on selected product from listing page
	Given Enter Levis in search component
	And User clicks on search magnifier
	When User selects first product from product listing page
	Then Product detail page of selected product should open

@MyntraDemo
Scenario: Verify login page redirection
	Given Browser is opened and url is launched completely
	When User clicks on login link from profile section
	Then Login page should open

@MyntraDemo
Scenario: Verify mens t-shirts sections should only show t-shirts	
	Given Browser is opened and url is launched completely
	When User clicks on mens t-shirts sections
	Then Product which contains t-shirt in product name should be shown

@MyntraDemo	
Scenario: Verify brand filter at listing page
	Given User is on lipstick section of beauty listing page
	When Selects first brand filter from filter section
	Then Product of only selected brand should be shown at result page		
	