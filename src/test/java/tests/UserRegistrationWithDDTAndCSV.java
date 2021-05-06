package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndCSV extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;


	CSVReader reader;

	@Test(priority = 1 , alwaysRun = true)
	public void RegisterSuccessfully() throws InterruptedException, IOException
	{

		// get csv file path
		String CSV_File = System.getProperty("user.dir")+"/src/test/java/data/userDataCSV.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		String[] csvCell;

		// while loop will be executed till the last valye in CSV File
		while((csvCell = reader.readNext()) != null)
		{
			String fName = csvCell[0];
			String lName = csvCell[1];
			String email = csvCell[2];
			String pw	 = csvCell[3];

			homeObject = new HomePage(driver);
			homeObject.openRegPage();

			registerObject = new UserRegistrationPage(driver);
			Thread.sleep(200);

			registerObject.userRegistration(fName, lName, "7" , "4", "1996", email, pw);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
			Thread.sleep(200);
			registerObject.userLogout();
			Thread.sleep(200);
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			Thread.sleep(200);
			loginObject.userCanLogin(email, pw);
			Thread.sleep(200);
			Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
			registerObject.userLogout();

		}



	}
}
