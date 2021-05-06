package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	String prodcutName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserCanSearchForProduct() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(prodcutName);
		Thread.sleep(400);
		searchObject.OpenProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameAppear.getText().equalsIgnoreCase(prodcutName));
	}

}
