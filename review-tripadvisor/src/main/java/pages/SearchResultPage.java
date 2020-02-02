package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebDriverUtils;

public class SearchResultPage {
	WebDriver driver;
	WebDriverUtils utils = new WebDriverUtils();
	@FindBy(xpath="//span[text()='Club Mahindra Madikeri, Coorg']")
	private WebElement clubLink;
	
	@FindBy(xpath="//a[text()='All results']")
	private WebElement allResultsLnk;
	
	@FindBy(xpath="//a[text()='Hotels']")
	private WebElement hotelsLink;
	
	@FindBy(xpath="//a[text()='Holiday Homes']")
	private WebElement holidayhomesLink;
	
	@FindBy(xpath="//a[text()='Restaurants']")
	private WebElement restaurantsLink;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public HotelReviewPage selectHotelLink()
	{
		clubLink.click();
		utils.switchToChildWindow(driver);
		return new HotelReviewPage(driver);
	}
	

}
