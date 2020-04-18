package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.JavaScriptUtil;

import BasePage.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (flash.equalsIgnoreCase("yes")) {
				JavaScriptUtil.flash(element, driver);
			}
		} catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " + locator);
		}
		return element;
	}

	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while click on  webelement " + locator);
		}
	}

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
		return text;
	}

	public String waitForGetPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public String waitGetText(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some exception occured while checking webelement displayed " + locator);
			return false;
		}
	}

	public void moveToElement(WebDriver driver, By locator) {
		waitForElementPresent(locator);
		try {
			WebElement target = driver.findElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(target).build().perform();
		} catch (Exception e) {
			System.out.println("Some exception occured while move to element " + locator);
		}
	}

	public void selectDropDownValueByValue(By locator, String value) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public String selectDropDownValueByIndex(WebDriver driver, By locator, String value) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		select.selectByValue(value);
		WebElement option = select.getFirstSelectedOption();
		String SelectedText = option.getText();
		return SelectedText;
	}

	public List<String> printResults(By locator1, By locator2) {
		
		List<WebElement> hotelTitleText = driver.findElements(locator1);
		List<WebElement> distanceText = driver.findElements(locator2);
		List<String> milesHotel = new ArrayList<String>();
		int j = 1;
		for (int i = 0; i < distanceText.size(); i++) {
			String fullDistance = distanceText.get(i).getText();
			String hotelTitle = hotelTitleText.get(i).getText();
			String distance = fullDistance.split(" ")[0].trim();
			double dist = Double.parseDouble(distance);
			if (dist < 10 ) {
				milesHotel.add(j + ". " + dist + " Miles " + hotelTitle);
				j++;
			}
		}	
		return milesHotel;
	}
	public List<WebElement> getAllTemps(By locator){
		List<WebElement> allTemps = driver.findElements(locator);
		for (int i =0; i<allTemps.size(); i++){
			System.out.println(allTemps.get(i).getText());
		}
		return allTemps;
	}
	
}
