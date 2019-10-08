package com.ww.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {
	
	/*This method will return a text from a hidden element
	 * 
	 * @param WebElement
	 * 
	 */
	public static String getHiddenText(WebElement element){
	    return (String) ((JavascriptExecutor) driver).executeScript(
	        "return jQuery(arguments[0]).text();", element);
	}

	/**
	 * This method will select a specified value from a drop down
	 * 
	 * @author Tolik
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected = false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text " + text + " is selected");
				isSelected = true;
				break;
			}
		}
		if (!isSelected) {
			System.out.println("Option with text +" + text + "is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * 
	 * @author Tolik
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}
	
	
	/**
	 * Method will accept alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * Method will accept alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will dismiss alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}

	/**
	 * Method will get text of an alert
	 * 
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {

		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}

	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will switch control to the specified frame
	 * 
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
	public static void waitForElementBeVisible(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
	public static void waitForElementBeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
	public static void waitForElementBeClickable(WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Method that will wait for element to be visible
	 * 
	 * @param WebElement element, int time
	 */
	public static void waitForElementBeClickable(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
	 * Method that will take  screenshot
	 * 
	 * @param 
	 */

	public static byte[] takeScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screen = ts.getScreenshotAs(OutputType.BYTES);

		return screen;
	}
	
	/**
	 * Method that will scroll down
	 * 
	 * @param int 
	 */

	public static void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixels + ")");
	}
	/**
	 * Method that will scroll up
	 * 
	 * @param int 
	 */

	public static void scrollUp(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixels + ")");
	}
	/**
	 * Method that will use js to click
	 * 
	 * @param element 
	 */

	public static void jsClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	/**
	 * Method that will use  click
	 * 
	 * @param element 
	 */

	public static void click(WebElement element) {
		element.click();
	}

	public static void selectList(WebElement element, String text) {

		List<WebElement> listLocations = element.findElements(By.tagName("li"));
		for (WebElement li : listLocations) {
			String liText = li.getAttribute("innerHTML");

			if (liText.contains(text)) {
				li.click();
				break;
			}
		}
	}

	public static void waitForElementBeInvisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	/**
	 * Method that will return current system date
	 * 
	 * @param
	 */
	public static String getCurrentDate() {
		
		DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		
		return dateFormat.format(date);
				
	}
	
	/**
	 * Method that will return current week day
	 * 
	 * @param
	 */
	
	public static String getWeekDay() {
		
		 Date now = new Date();

	        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week abbreviated
	     
	 
	        simpleDateformat = new SimpleDateFormat("E"); // the day of the week spelled out completely
	     
		 
		
		return simpleDateformat.format(now);
				
	}
	

}