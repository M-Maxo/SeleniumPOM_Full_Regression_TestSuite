package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToWishlistPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToWishlistTest extends TestBase {
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToWishlistPage wishlistObject;
	
	@Test
	public void UserCanSelectFromList() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest("MacB");
		
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddProductToWishlist();
		
		wishlistObject = new AddProductToWishlistPage(driver);
		Assert.assertEquals(wishlistObject.productNameInWishlist.getText(), "Apple MacBook Pro 13-inch");
		Thread.sleep(2000);
		wishlistObject.RemoveProduct();
		Assert.assertEquals(wishlistObject.removeMsg.getText(),"The wishlist is empty!");
	}

}
