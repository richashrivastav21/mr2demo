package com.mr2demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mr2demo.keywords.Keyword;
import com.mr2demo.waits.WaitFor;

public class HomePage {
	
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	
	// WebElements
	@FindBy(css = "div.desktop-query>input[placeholder*='Search for']")
	public WebElement searchComponent;
	
	@FindBy(css = "div[class='desktop-userIconsContainer']>span[class='desktop-userTitle']")
	public WebElement profile;
	
	@FindBy(css = "a[data-track='login']")
	public WebElement loginButton;
	
	@FindBy(css = "a[data-group='men']")
	public WebElement menSection;
	
	@FindBy(css = "a[data-group='women']")
	public WebElement womenSection;
	
	@FindBy(css = "a[data-group='home-&-living']")
	public WebElement homeLivingSection;
	
	@FindBy(css = "a[data-group='beauty']")
	public WebElement beautySection;
	
	@FindBy(css = "a[href='/men-tshirts']")
	public WebElement menTShirts;
	
	@FindBy(css = "a[href='/women-kurtas-kurtis-suits']")
	public WebElement womentKurtasSuits;
	
	@FindBy(css = "a[href='/home-furnishing?f=Categories%3ARunners%3A%3AType%3ABed']")
	public WebElement bedRunners;
	
	@FindBy(css = "div[data-group='beauty']>li>ul>li>a[href='/lipstick']")
	public WebElement lipstick;
	
	@FindBy(css = "a[class='myntraweb-sprite desktop-logo sprites-headerLogo ']")
	public WebElement myntraLogo;
	
	@FindBy(css = "span[class='myntraweb-sprite desktop-iconWishlist sprites-headerWishlist']")
	public WebElement wishlistIcon;
	
	@FindBy(css = "span[class='myntraweb-sprite desktop-iconBag sprites-headerBag']")
	public WebElement cartIcon;
	
	@FindBy(css = "span.sprites-search")
	public WebElement searchMagnifier;
	
	private By menTshirt = By.cssSelector("a[href='/men-tshirts']");
	private By womenKurtaSuit = By.cssSelector("a[href='/women-kurtas-kurtis-suits']");
	private By lipStick = By.cssSelector("div[data-group='beauty']>li>ul>li>a[href='/lipstick']");
	private By bedRunner = By.cssSelector("a[href='/home-furnishing?f=Categories%3ARunners%3A%3AType%3ABed']");
	
	
	public HomePage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	// Actions
	public void enterProductToSearch(CharSequence... productName) {
		LOG.info("Searching product with name "+productName);
		searchComponent.sendKeys(productName);
	}
	
	public void clickOnLogin() {
		Keyword keyword = new Keyword();
		keyword.performMouseHover(profile);
		LOG.info("Going to click on login button under profile");
		loginButton.click();
	}
	
	public void clickOnMenTshirtsSection() {
		Keyword keyword = new Keyword();
		keyword.performMouseHover(menSection);
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(menTshirt);
		LOG.info("Going to click on mens tshirt section under mens category");
		menTShirts.click();
	}
	
	public void clickOnWomenKurtasSuitsSection() {
		Keyword keyword = new Keyword();
		keyword.performMouseHover(womenSection);
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(womenKurtaSuit);
		LOG.info("Going to click on women kurta suit section under womens category");
		womentKurtasSuits.click();
	}
	
	public void clickOnBedRunnersSection() {
		Keyword keyword = new Keyword();
		keyword.performMouseHover(homeLivingSection);
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(bedRunner);
		LOG.info("Going to click on bed runner section under home living category");
		bedRunners.click();
	}
	
	public void clickOnLipstickSection() {
		Keyword keyword = new Keyword();
		keyword.performMouseHover(beautySection);
		WaitFor waitFor = new WaitFor();
		waitFor.elementToBeClickable(lipStick);
		LOG.info("Going to click on lipstick section under beauty category");
		lipstick.click();
	}
	
	public void clickOnMyntraLogo() {
		LOG.info("Going to click on myntra logo");
		myntraLogo.click();
	}
	
	public void clickOnWishlist() {
		LOG.info("Going to click on wishlist logo");
		wishlistIcon.click();
	}
	
	public void clickOnBag() {
		LOG.info("Going to click on cart logo");
		cartIcon.click();
	}
	
	public void clickOnSearchMagnifier() {
		LOG.info("Going to click on search magnifier");
		searchMagnifier.click();
	}
	
}