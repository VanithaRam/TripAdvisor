package generic;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;

public abstract class BaseClass implements iAutoConst 
{
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public WebDriver driver;
	public FileLibrary flib = new FileLibrary();
	public WebDriverUtils utils = new WebDriverUtils();
	public ExtentReports report;
	
	@BeforeSuite
	public void GenerateExtReport()
	{
	    report = new ExtentReports("./src/main/resources/ExtentReports/advanceReport.html");
		report.loadConfig(new File("./src/main/resources/ExtentReports/extent-config.xml"));
	}
	
	@BeforeTest
	public void launchBrowser() throws IOException 
	{
		String browser = flib.getDataFromProperties("browserName");
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void closeReport()
	{
		report.flush();
		report.close();
	}
}
