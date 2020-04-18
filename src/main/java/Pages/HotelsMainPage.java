package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;
import Utilities.JavaScriptUtil;

public class HotelsMainPage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	//JavaScriptUtil javaScriptUtil;
	
	By destination = By.id("qf-0q-destination");
	By checkInArea = By.cssSelector("input[id='qf-0q-localised-check-in']");
	By checkInDate = By.cssSelector("td[data-date='2019-12-27']");
	By checkOutArea = By.cssSelector("input[id='qf-0q-localised-check-out']");
	By checkOutDate = By.cssSelector("td[data-date='2019-12-29']");
	By childArea = By.id("qf-0q-room-0-children");
	By firstChildAge = By.id("qf-0q-room-0-child-0-age");
	By secondChildAge = By.id("qf-0q-room-0-child-1-age");
	By searchBtn = By.cssSelector("button.cta.cta-strong");
	By closePopUp = By.cssSelector("a.footer-continue-link.di-ib.fw-bold");
	By firstDropDownCity = By.cssSelector("#citysqm-asi0-s0");
	
	
	
	public HotelsMainPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	public  void userSelections() throws InterruptedException{
		elementUtil.doClick(closePopUp);
		elementUtil.doSendKeys(destination, "New York, New York, United States of America");
		elementUtil.doClick(firstDropDownCity);
		elementUtil.doClick(checkInArea);
		elementUtil.doClick(checkInDate);
		elementUtil.doClick(checkOutArea);
		elementUtil.doClick(checkOutDate);
		elementUtil.selectDropDownValueByValue(childArea, "2");
		elementUtil.selectDropDownValueByValue(firstChildAge, "9");
		elementUtil.selectDropDownValueByValue(secondChildAge, "6");
		Thread.sleep(1500);
		elementUtil.doClick(searchBtn);	
	}	
}
