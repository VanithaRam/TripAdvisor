package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebDriverUtils;

public class HotelReviewPage 
{
	WebDriver driver;
	WebDriverUtils utils = new WebDriverUtils();
	
	@FindBy(xpath="//a[@class='ui_button primary']")
	private WebElement writeReviewBTN;
	
	public HotelReviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public UserReviewEditPage writeReviewForHotel()
	{
		writeReviewBTN.click();
		utils.switchToChildWindow(driver);
		return new UserReviewEditPage(driver);
	}
}
