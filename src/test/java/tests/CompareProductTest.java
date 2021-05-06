package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareProductTest extends TestBase{

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	CompareProductPage compareObject;

	@Test
	public void UserCanCompareProduct() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new CompareProductPage(driver);
		
		searchObject.ProductSearchAutoSuggest("MacB");
		detailsObject.AddToCompareList();
		searchObject.ProductSearchAutoSuggest("Asu");
		detailsObject.AddToCompareList();
		detailsObject.GoToComparisonPage();
		
		Assert.assertEquals(compareObject.asusTxt.getText(), "Asus N551JK-XO076H Laptop");
		Assert.assertEquals(compareObject.macTxt.getText(), "Apple MacBook Pro 13-inch");
		compareObject.ClearComparing();
		Assert.assertEquals(compareObject.cleanCompare.getText(), "You have no items to compare.");
		
		
		
		
	}

}
