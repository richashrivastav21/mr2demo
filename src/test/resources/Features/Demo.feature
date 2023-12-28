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
	
@MyntraDemo	
Scenario: Verify clear filter functionality at listing page
	Given User is at women kurta listing page
	When Selects first brand filter from filter section
	And User clicks on clear filter 
	Then User should get redirected to women kurta section

@MyntraDemo	
Scenario: Verify myntra logo redirection
	Given User is at bed runner listing page
	When User clicks on myntra logo
	Then User should get redirected to home page

@MyntraDemo	
Scenario: Verify wishlist page
	Given Browser is opened and url is launched completely
	When User clicks on wishlist icon
	Then Wishlist page should open				 	

@MyntraDemo	
Scenario: Verify cart page
	Given Browser is opened and url is launched completely
	When User clicks on cart icon
	Then Cart page should open			
	
@MyntraDemo	
Scenario: verify when user searches fo Levis  then all results  should contain products from brand Levis
Given Enter Levis in search component
When User click on search magnifire
Then All results populates must contain word levis in it

@MyntraDemo
Scenario: verify the Libas kurti then all results should contain product brand Libas
Given The Enter Libas in search component
When User click on search magnifire for serach
Then All results should be display 

@MyntraDemo
Scenario: Verify the Acrylic Fabric kurtis then result should display
Given The Enter Kurtis in Search Component
When  User Click on search magnifire product
When  Click on Fabric menu
When  Click on Acrylik CheckBox
Then  result should be display the Acrylik 

@MyntraDemo
Scenario: verify the Libas kurti then result show the Libas kurti set
Given The Enter Libas kurti in search component
When User click on search magnifire for serach Libas kurti Set
Then Click on Women Black Pure Cotton Ethnic Motifs Set