package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.WebDriverUtils;

public class UserReviewEditPage {
	
	WebDriver driver;
	WebDriverUtils utils = new WebDriverUtils();
	@FindBy(xpath="//div[@class='easyClear bigRatingParent']")
	private WebElement bubbleRating;
	
	@FindBy(id="ReviewTitle")
	private WebElement reviewTitle;
	
	@FindBy(id="ReviewText")
	private WebElement reviewText;
	
	@FindBy(xpath="//div[@id='DQ_RATINGS']")
	private WebElement hotelRatingsSec;
	
	@FindBy(xpath="//span[contains(@class,'answersBubbles ui_bubble_rating')]")
	private List<WebElement> hotelRatings;
	
	@FindBy(id="noFraud")
	private WebElement submitRevChkBox;
	
	
	public UserReviewEditPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void giveRatingsAndReview(WebDriver driver, String revTitle, String revTxt) 
	{
		utils.mouseHover(driver, bubbleRating);
		reviewTitle.sendKeys(revTitle);
		reviewText.sendKeys(revTxt);
		if(hotelRatingsSec.isDisplayed())
		{
			utils.selectTheHotelRatings(driver, hotelRatings);
		}
		submitRevChkBox.click();
	}

	
	
}
