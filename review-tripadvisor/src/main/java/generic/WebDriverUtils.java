package generic;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtils implements iAutoConst 
{
	/**
	 * Implicitly Waits for element to load
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	
	/**
	 * Maximizes the Window
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Explicitly Waits until Element is Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,ETO);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Explicitly waits for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,ETO);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * custom wait
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebDriver driver, WebElement element) throws InterruptedException
	{
		int count = 1;
		while(count<=20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable t)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * 	Searchs the division and hovers on the elements inside it
	 * @param driver
	 * @param element
	 */
	public void selectTheHotelRatings(WebDriver driver , List<WebElement> element)
	{
		for(WebElement ele : element)
		{
			mouseHover(driver,ele);
		}
	}
		
	/**
	 * Hovers the mouse on the bubble ratings
	 * @param driver
	 * @param element
	 */
    public void mouseHover(WebDriver driver, WebElement element) 
    {
      	Actions act = new Actions(driver);
       	for(int i=0 ; i<=150 ; i=i+50)
       	{
       		act.moveToElement(element, i, 0).click().perform();
       	}
    }

   /**
    * Switches the control to child browser
    * @param driver
    */
	public void switchToChildWindow(WebDriver driver)
	{
		Set<String> allWHS = driver.getWindowHandles();
		for(String wh : allWHS)
		{
			driver.switchTo().window(wh);
		}
	}
}