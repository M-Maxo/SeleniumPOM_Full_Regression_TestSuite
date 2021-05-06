package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement fnTxt;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lnTxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityTxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressTxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement postcodeTxt;
	
	@FindBy(css = "button.button-1.new-address-next-step-button")
	WebElement continueBtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingRdo;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	WebElement continueShippingBtn;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement continuePaymentBtn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement continueInfoBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement thanksLbl;
	
	@FindBy(css = "div.title")
	public WebElement successMsg;
	
	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;
	
	
	public void RegisteredUserCheckoutProduct(String CountryName , String address,
			String postCode, String phone, String city, String productName) throws InterruptedException
	{
		select = new Select(countryList);
		select.selectByVisibleText(CountryName);
		
		setTextElemenet(cityTxt, city);
		setTextElemenet(addressTxt, address);
		setTextElemenet(postcodeTxt, postCode);
		setTextElemenet(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
		Thread.sleep(1000);
		clickButton(confirmBtn);
		
	}
	
	

}
