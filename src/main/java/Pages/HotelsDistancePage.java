package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.ElementUtil;
import Utilities.JavaScriptUtil;

public class HotelsDistancePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	
	By threeStars = By.id("f-label-star-rating-3");
	By fourStars = By.cssSelector("input[id='f-star-rating-4']");
	By fiveStars = By.cssSelector("input[id='f-star-rating-5']");
//	By landMark = By.xpath("//h3[contains(text(),'Landmarks')]");
//	By cityCenter = By.id("f-label-lid-1506246");
//	By mileBox = By.id("f-distance");
    By hotelTitles = By.cssSelector("a.property-name-link");
    By distance=By.cssSelector("ul.property-landmarks li:nth-child(1)");
	
	public HotelsDistancePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public List<String> selectHotels3() throws InterruptedException{
		elementUtil.doClick(threeStars);
//		elementUtil.waitForElementPresent(mileBox);
//		elementUtil.doClick(landMark);
//		elementUtil.doClick(cityCenter);
//		elementUtil.waitForElementPresent(mileBox);
//		elementUtil.doClick(mileBox);
//		elementUtil.selectDropDownValueByValue(mileBox, "10");
		JavaScriptUtil.scrollDownWithIterator(driver);
		Thread.sleep(2000);
		return elementUtil.printResults(hotelTitles, distance);
		
	
	}
	public  List<String> selectHotels4() throws InterruptedException{
		elementUtil.doClick(fourStars);
		//elementUtil.doClick(landMark);
		//elementUtil.waitForElementPresent(cityCenter);
		//elementUtil.doClick(cityCenter);
		JavaScriptUtil.scrollDownWithIterator(driver);
		Thread.sleep(2000);
		return elementUtil.printResults(hotelTitles, distance);
	
	}
	public  List<String> selectHotels5() throws InterruptedException{
		elementUtil.doClick(fiveStars);
		//elementUtil.doClick(landMark);
		//elementUtil.waitForElementPresent(cityCenter);
		//elementUtil.doClick(cityCenter);
		JavaScriptUtil.scrollDownWithIterator(driver);
		Thread.sleep(2000);
		return elementUtil.printResults(hotelTitles, distance);
	
	}
	

}
