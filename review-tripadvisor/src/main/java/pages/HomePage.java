package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@title='Search']")
	private WebElement search;
	
	@FindBy(xpath="(//input[@title='Search'])[2]")
	private WebElement searchBoxInCenter;

	@FindBy(xpath="//input[@placeholder='Search Tripadvisor']")
	private WebElement searchBox;
	
	@FindBy(xpath="//span[text()='Hotels']")
	private WebElement hotelsLink;
	
	@FindBy(xpath="//span[text()='Things to do']")
	private WebElement thingsToDo;
	
	@FindBy(xpath="//span[text()='Restaurants']")
	private WebElement Restaurants;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage searchForHotel(String hotelName)
	{
	try
	{
		search.click();
		searchBox.sendKeys(hotelName,Keys.ENTER);
	}
	catch(Exception e)
	{
		searchBoxInCenter.sendKeys(hotelName,Keys.ENTER);
	}
	return new SearchResultPage(driver);
	
	}
}
