package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HotelsMainPage;
import Utilities.Constants;

public class HotelsMainPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsMainPage hotelsMainPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		hotelsMainPage = new HotelsMainPage(driver);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1, description = "This method is getting title")
	private void getTitle() {
		String title = hotelsMainPage.getHomePageTitle();
		System.out.println("Web Page Title is --> " +title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);

	}

	@Test(priority = 2,description= "This method is getting destination,check-in and check-out date and childrens number")
	private void doSendAndClick() throws InterruptedException {
		hotelsMainPage.userSelections();

	}
	

	@AfterMethod
	private void tearDown() {
		driver.quit();

	}

}
