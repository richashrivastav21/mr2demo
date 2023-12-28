package com.mr2demo.stepdefinitions;

import com.mr2demo.keywords.Keyword;
import com.mr2demo.pages.CartPage;
import com.mr2demo.pages.HomePage;
import com.mr2demo.pages.LoginPage;
import com.mr2demo.pages.ProductDetailPage;
import com.mr2demo.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyntraDemoSteps {

	@Given("Enter Levis in search component")
	public void enterProductToSearch() {
		HomePage homePage = new HomePage();
		homePage.enterProductToSearch("Levis");
	}

	@When("User clicks on search magnifier")
	public void clickOnSearchMagnifier() {
		HomePage homePage = new HomePage();
		homePage.clickOnSearchMagnifier();
	}

	@Then("All results populated must contains word Levis in it")
	public void assertResultsPage() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProducttitleContains("Levis");
	}

	@When("User selects first product from product listing page")
	public void selectFirstProductFromListingPage() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnFirstProduct();
	}

	@Then("Product detail page of selected product should open")
	public void validateProductDetailPage() {
		Keyword keyword = new Keyword();
		String parentWindowHandle = keyword.getparentWindowHandle();
		keyword.switchToChildWindow();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyProducDetailPageTitle("Levis");
		keyword.closeBrowser();
		keyword.switchToParentWindow(parentWindowHandle);
	}

	@Given("Browser is opened and url is launched completely")
	public void openBrowserAndLaunchurl() {
	}

	@When("User clicks on login link from profile section")
	public void clickOnLoginButton() {
		HomePage homePage = new HomePage();
		homePage.clickOnLogin();
	}

	@Then("Login page should open")
	public void validateLoginPage() {
		LoginPage loginPage = new LoginPage();
		loginPage.validateLoginPage();
	}

	@When("User clicks on mens t-shirts sections")
	public void clickOnTShirtsSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnMenTshirtsSection();
	}

	@Then("Product which contains t-shirt in product name should be shown")
	public void validateProductName() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProductNameContains("T-shirt");
	}

	@Given("User is on lipstick section of beauty listing page")
	public void clickOnLipstickSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnLipstickSection();
	}

	@When("Selects first brand filter from filter section")
	public void clickOnFirstBrandFilter() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnFirstBrandFilter();
	}

	@Then("Product of only selected brand should be shown at result page")
	public void validateProductTitle() {
		SearchResultPage resultPage = new SearchResultPage();
		String brandFilterName = resultPage.getFirstBrandFilterName().split("\\(")[0];
		resultPage.verifyProducttitleContains(brandFilterName);
	}
	
	/*
	 * @Given("Enter Levis in search component") public void
	 * enter_levis_in_search_component() { HomePage homepage = new HomePage();
	 * homepage.enterProductToSearch("Levis");
	 * 
	 * }
	 */

	@When("User click on search magnifire")
	public void clickOnSearchMagnifire() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();

	}

	@Then("All results populates must contain word levis in it")
	public void assertResults() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProducttitleContains("Levis");
	}

//	2 Sd
	@Given("The Enter Libas in search component")
	public void enter_libas_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Libas");
	}

	@When("User click on search magnifire for serach")
	public void user_click_on_search_magnifire_for_serach() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();

	}

	@Then("All results should be display")
	public void all_results_should_be_display() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProducttitleContains("Libas");

	}

//3 Sd
	@Given("The Enter Kurtis in Search Component")
	public void the_enter_kurtis_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Kurtis");
	}

	@When("User Click on search magnifire product")
	public void user_click_on_search_magnifire_product() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();

	}

	@When("Click on Fabric menu")
	public void click_on_fabric_menu() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnFabricMenu();

	}

	@When("Click on Acrylik CheckBox")
	public void click_on_acrylik_check_box() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnAcrylickFabric();

	}

	@Then("result should be display the Acrylik")
	public void result_should_be_display_the_acrylik() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProducttitleContains("Kurtis");

	}

//4
	@Given("The Enter Libas kurti in search component")
	public void the_enter_libas_kurti_in_search_component() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Libas");
	}

	@When("User click on search magnifire for serach Libas kurti Set")
	public void user_click_on_search_magnifire_for_serach_libas_kurti_set() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();

	}

	@Then ("Click on Women Black Pure Cotton Ethnic Motifs Set")
	public void click_on_Women_Black_Pure_Cotten_Ethnic_Motifs_Set() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.searchItem();
	}
	
	@Given("User is at women kurta listing page")
	public void clickOnWomenKurtasSuitsSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnWomenKurtasSuitsSection();
	}

	@When("User clicks on clear filter")
	public void clickOnClearFilter() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnClearAllFilter();
	}

	@Then("User should get redirected to women kurta section")
	public void validateKurtaSectionUrl() {
		Keyword.validatePageUrl("https://www.myntra.com/women-kurtas-kurtis-suits");
	}

	@Given("User is at bed runner listing page")
	public void clickOnBedRunnersSection() {
		HomePage homePage = new HomePage();
		homePage.clickOnBedRunnersSection();
	}

	@When("User clicks on myntra logo")
	public void clickOnMyntraLogo() {
		HomePage homePage = new HomePage();
		homePage.clickOnMyntraLogo();
	}

	@Then("User should get redirected to home page")
	public void validateHomePageUrl() {
		Keyword.validatePageUrl("https://www.myntra.com/");
	}

	@When("User clicks on wishlist icon")
	public void clickOnWishlist() {
		HomePage homepage = new HomePage();
		homepage.clickOnWishlist();
	}

	@Then("Wishlist page should open")
	public void validateWishlistPageUrl() {
		Keyword.validatePageUrl("https://www.myntra.com/wishlist");
	}

	@When("User clicks on cart icon")
	public void clickOnBag() {
		HomePage homepage = new HomePage();
		homepage.clickOnBag();
	}

	@Then("Cart page should open")
	public void validateCartPage() {
		CartPage cartpage = new CartPage();
		cartpage.validateCartPage();
	}

}
