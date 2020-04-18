package Tests;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HotelsDistancePage;
import Pages.HotelsMainPage;

public class HotelsDistancePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsMainPage hotelsMainPage;
	HotelsDistancePage hotelsDistancePage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		hotelsMainPage = new HotelsMainPage(driver);
		hotelsMainPage.userSelections();
		hotelsDistancePage = new HotelsDistancePage(driver);
		
		try{
			Thread.sleep(5000);
		}catch (InterruptedException e){
			e.printStackTrace();
		}

	}
	@Test(priority=1,description="This method is getting 3 stars hotels name")
	public void threeStarsHotels() throws InterruptedException{
		
		List<String> titles3stared = hotelsDistancePage.selectHotels3();
		System.out.println("THREE STARS HOTELS");
		for(String element : titles3stared){
			System.out.println(element);
		}
	}
	
	@Test(priority=2,description="This method is getting 4 stars hotels name")
	public void fourStarsHotels() throws InterruptedException{
		
		List<String> titles4stared = hotelsDistancePage.selectHotels4();
		System.out.println("FOUR STARS HOTELS");
		for(String element : titles4stared){
			System.out.println(element);
		}
		
	}
	
	@Test(priority=3,description="This method is getting 5 stars hotels name")
	public void fiveStarsHotels() throws InterruptedException{
		
		List<String> titles5stared = hotelsDistancePage.selectHotels5();
		System.out.println("FIVE STARS HOTELS");
		for(String element : titles5stared){
			System.out.println(element);
		}
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
