package mr2demo;


import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import com.mr2demo.base.TestBase;
import com.mr2demo.keywords.Keyword;
import com.mr2demo.pages.CartPage;
import com.mr2demo.pages.HomePage;
import com.mr2demo.pages.LoginPage;
import com.mr2demo.pages.ProductDetailPage;
import com.mr2demo.pages.SearchResultPage;

public class Test_Cases extends TestBase{
	
	@Test(enabled=true)
	public void validateProductSearch() {
		//HomePage homepage = PageFactory.initElements(Keyword.getDriver() , HomePage.class);
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Levis",Keys.ENTER);
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProducttitleContains("Levis");
		
	}
	
	
	@Test(enabled=true)
	public void validateProductViewPage() {
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Levis",Keys.ENTER);
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.clickOnFirstProduct();
		Keyword keyword = new Keyword();
		String parentWindowHandle = keyword.getparentWindowHandle();
		keyword.switchToChildWindow();
		ProductDetailPage productDetailPage = new ProductDetailPage();
		productDetailPage.verifyProducDetailPageTitle("Levis");
		keyword.closeBrowser();
		keyword.switchToParentWindow(parentWindowHandle);
		
	}
	
	
	@Test(enabled=false)
	public void validateLoginPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnLogin();
		LoginPage loginPage = new LoginPage();
		loginPage.validateLoginPage();
	}
	

	@Test(enabled=false)
	public void validateMenTshirtsSectionListingPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnMenTshirtsSection();
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProductNameContains("T-shirt");
	}
	
	@Test(enabled=false)
	public void validateBrandFilterAtListingPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnLipstickSection();
		SearchResultPage resultPage = new SearchResultPage();
		String brandFilterName = resultPage.getFirstBrandFilterName().split("\\(")[0];
		resultPage.clickOnFirstBrandFilter();
		resultPage.verifyProducttitleContains(brandFilterName);
	}
	
	@Test(enabled=false)
	public void validateClearFilterAtListingPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnWomenKurtasSuitsSection();
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProductNameContains("Kurta");
		resultPage.clickOnFirstBrandFilter();
		resultPage.clickOnClearAllFilter();
		Keyword.validatePageUrl("https://www.myntra.com/women-kurtas-kurtis-suits");
		
	}
	
	
	@Test(enabled=false)
	public void validateMyntraHomePageRedirectionFromListingPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnBedRunnersSection();
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProductNameContains("Runner");
		homepage.clickOnMyntraLogo();
		Keyword.validatePageUrl("https://www.myntra.com/");
		
	}
	
	@Test(enabled=false)
	public void validateWishlistPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnWishlist();
		Keyword.validatePageUrl("https://www.myntra.com/wishlist");
	}
	
	@Test(enabled=false)
	public void validateCartPage() {
		HomePage homepage = new HomePage();
		homepage.clickOnBag();
		CartPage cartpage = new CartPage();
		cartpage.validateCartPage();
	}
	
}
