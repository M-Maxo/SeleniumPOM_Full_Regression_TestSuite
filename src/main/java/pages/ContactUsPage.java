package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement fullName;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Enquiry")
	WebElement enquiry;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	public void ContactUsInfo(String contactName , String contactEmail , String contactEnquiry ) 
	{
		setTextElemenet(fullName, contactName);
		setTextElemenet(email, contactEmail);
		setTextElemenet(enquiry, contactEnquiry);
		clickButton(submitBtn);
	}

}
