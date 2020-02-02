package scripts;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import generic.BaseClass;
import generic.iFilePath;
import pages.HomePage;
import pages.HotelReviewPage;
import pages.SearchResultPage;
import pages.UserReviewEditPage;

public class HotelReviewTest extends BaseClass implements iFilePath {
	
	@Test
	/**
	 * Review and Rates the hotel club mahindra
	 */
	public void reviewTest()
	{
		ExtentTest logger = report.startTest("reviewTest");
		logger.log(LogStatus.INFO, "Login to the application");
		driver.get(flib.getDataFromProperties("tripAdvisorUrl"));
		HomePage tripHome = new HomePage(driver);
		logger.log(LogStatus.INFO, "Search For Club Mahindra");
		SearchResultPage schResult = tripHome.searchForHotel(flib.getDataFromProperties("hotelName"));
		logger.log(LogStatus.INFO, "Select the first Club Mahindra link");
		HotelReviewPage hotelRev = schResult.selectHotelLink();
		logger.log(LogStatus.INFO, "Click on Write Review Button");
		UserReviewEditPage userRev = hotelRev.writeReviewForHotel();
		String title = flib.getData(EXCEL_PATH, "TripAdvisor", 1, 0);
		String text= flib.getData(EXCEL_PATH, "TripAdvisor", 1, 1);
		logger.log(LogStatus.INFO, "Write Review For Club Mahindra");
		userRev.giveRatingsAndReview(driver,title,text);
		logger.log(LogStatus.PASS, "Hotel Reviewed");
		report.endTest(logger);
	}
}
