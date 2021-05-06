package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToShopingCartPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToShopingCartTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToShopingCartPage cartObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
	public void UserCanSearchForProduct() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest("macb");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameAppear.getText().contains(productName));
	}
	
	@Test(priority = 2)
	public void UserCanAddProductToShopingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(2000);
		cartObject = new AddProductToShopingCartPage(driver);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartObject.totalLbl.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart()
	{
		cartObject = new AddProductToShopingCartPage(driver);
		cartObject.RemoveProduct();
	}
	

}
