package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductPage extends PageBase{

	public CompareProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement asusTxt;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement macTxt;
	
	@FindBy(css = "a.clear-list")
	WebElement clearCompare;
	
	@FindBy(css = "div.no-data")
	public WebElement cleanCompare;
	
	public void ClearComparing()
	{
		clickButton(clearCompare);
	}
	
	

}
