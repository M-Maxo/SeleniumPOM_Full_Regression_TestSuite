package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class ProductReviewTest extends TestBase{


	/* 
	 * 1-User Registration
	 * 2-Search For Product
	 * 3-Add Review
	 */

	HomePage homeObject;
	UserRegistrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	String firstName = "Mahmoud";
	String lastName = "Adel";
	String email = "maxo3@yahoo.com";
	String Pw = "123456";

	String reviewTitle = "Software Testing.....";
	String reviewMsg = "Iam new tester in this field......";



	@Test
	public void userCanReviewProduct() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegPage();

		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(2000);
		registerObject.userRegistration(firstName, lastName, "7" , "4", "1996", email, Pw);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

		searchObject = new SearchPage(driver);
		searchObject.ProductSearchAutoSuggest("MacB");
		Thread.sleep(4000);

		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddUserReview();
		Thread.sleep(2000);

		reviewObject = new ProductReviewPage(driver);
		reviewObject.productReview(reviewTitle, reviewMsg);
		Assert.assertEquals(reviewObject.successMsg.getText(), "Product review is successfully added.");

	}

}
