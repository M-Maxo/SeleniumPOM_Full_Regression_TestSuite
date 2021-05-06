package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrncyTest extends TestBase {
	
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	
	@Test
	public void userCanChangeCurrency() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		detailsObject = new ProductDetailsPage(driver);
		homeObject.changeCurrency();
		
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest("MacB");
		Thread.sleep(4000);
		Assert.assertEquals(detailsObject.productPrice.getText() , "€1548.00");
		
	}
}
