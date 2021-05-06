package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SendEmailToFriendPage;
import pages.UserRegistrationPage;

public class SendEmailToFriendTest extends TestBase{
	
	// Information we will used it in home page
	HomePage homeObject;
	
	// Information to registration
	UserRegistrationPage registerObject;
	String firstName = "Mahmoud";
	String lastName = "Adel";
	String email = "maxo4@yahoo.com";
	String oldPw = "123456";
	String newPw = "123456789";
	
	// Information we will use to search about product
	String prodcutName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	// Informtion to send email to friend
	SendEmailToFriendPage emailObject;
	String friendEmail = "mohamed@test.com";
	String message = "You Are Amazing........";
	
	
	@Test
	public void sendEmailToFriend() throws InterruptedException
	{
		// Home Page
		homeObject = new HomePage(driver);
		homeObject.openRegPage();
		
		// Registration
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(2000);
		registerObject.userRegistration(firstName, lastName, "7" , "4", "1996", email, oldPw);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
		// Search About Product
		Thread.sleep(4000);
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearch(prodcutName);
		Thread.sleep(400);
		searchObject.OpenProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameAppear.getText().equalsIgnoreCase(prodcutName));
		detailsObject.SendEmailFriend();
		
		// Send Friend Email
		emailObject = new SendEmailToFriendPage(driver);
		Thread.sleep(2000);
		emailObject.sendEmail(friendEmail, message);
		Assert.assertTrue(emailObject.successMsg.getText().equalsIgnoreCase("Your message has been sent."));
	}

}
