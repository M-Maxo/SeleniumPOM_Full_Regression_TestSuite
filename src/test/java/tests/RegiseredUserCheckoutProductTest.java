package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToShopingCartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class RegiseredUserCheckoutProductTest extends TestBase{

	/* 
	 * 1- Register User
	 * 2- Search for product
	 * 3- Add to cart
	 * 4- Checkout
	 * 5- Logout
	 */
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddProductToShopingCartPage cartObject;
	CheckoutPage checkoutObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority = 1 , alwaysRun = true)
	public void RegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(200);
		registerObject.userRegistration("Mahmoud", "Adel", "7" , "4", "1996", "maxo@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void UserCanSelectFromList() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest("MacB");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameAppear.getText(), productName);
	}
	
	@Test(priority = 3)
	public void UserCanAddProductToShopingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(2000);
		cartObject = new AddProductToShopingCartPage(driver);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartObject.totalLbl.getText().contains("$3,600.00"));
	}
	
	@Test(priority = 4)
	public void UserCanCheckoutProduct() throws InterruptedException
	{
		checkoutObject = new CheckoutPage(driver);
		cartObject.OpenCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct("Egypt", "Test Address",
				"123456789", "3214978856", "Cairo", productName);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		Assert.assertTrue(checkoutObject.thanksLbl.isDisplayed());
	}
	
	@Test(priority = 5)
	public void userCanLogout()
	{
		registerObject.userLogout();
	}
	

}
