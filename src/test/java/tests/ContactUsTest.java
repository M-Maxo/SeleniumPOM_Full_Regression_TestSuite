package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage home;
	ContactUsPage contactPage;
	
	String email = "test@yahoo.com";
	String fullName = "Test User";
	String enquiry = "Hello Admin , Iam Trying testing";
	
	@Test
	public void UserCanUseContactUs() throws InterruptedException
	{
		home =new HomePage(driver);
		home.openContactUsPage();
		
		contactPage = new ContactUsPage(driver);
		Thread.sleep(500);
		contactPage.ContactUsInfo(fullName, email, enquiry);
		Thread.sleep(500);
		Assert.assertTrue(contactPage.successMessage.getText()
				.equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
		
		
	}

}
