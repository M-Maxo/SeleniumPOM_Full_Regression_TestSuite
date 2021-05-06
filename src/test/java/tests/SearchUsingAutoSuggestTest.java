package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchUsingAutoSuggestTest extends TestBase{
	
	String prodcutName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void UserCanSelectFromList() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameAppear.getText(), prodcutName);
	}

}
