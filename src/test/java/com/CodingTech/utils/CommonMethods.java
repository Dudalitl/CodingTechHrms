package com.CodingTech.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CodingTech.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	/**
	 * method that clears and send keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) { 
		element.clear();
		element.sendKeys(text);  
	}

	/**
	 * Method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrcheckBox
	 * @param value
	 */
	public static void clickRadioOrCheckBox(List<WebElement> radioOrcheckBox, String value) {
		String actualValue;
		for (WebElement el : radioOrcheckBox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}

	}

	/**
	 * Method that checks if text is there and then selects it
	 * 
	 * @param element
	 * @param textToSelect
	 */
	public static void selectDdValue(WebElement element, String textToSelect) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method that select value by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDdValue(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * method ACCEPTS alerts and catches exception is alert is not alert not
	 * presents
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method DISMISS alerts and catches exception is alert is not alert not
	 * presents
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}
	}

	/**
	 * method that gets texts of alerts and catches exception is alert is not alert
	 * not presents
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;

	}

	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(String nameOrid) {
		try {
			driver.switchTo().frame(nameOrid);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * method switches the focus to child window
	 */
	public static void swithToChildWindow() {
		String mainWindow=driver.getWindowHandle();
		Set<String>windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		 return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));

	}
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
		}
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js;
	}
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,"+pixel+")");
	}
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-"+pixel+")");
	}
	public static void wait(int second) {
		try {
		Thread.sleep(second*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method will select a date from the calender
	 * @param element
	 * @param text
	 */
	
	public static void selectCalenderDate(List<WebElement>element,String text) {
		for(WebElement pickDate:element) {
			if(pickDate.isEnabled()) {
			if(pickDate.getText().equals(text)) {
				pickDate.click();
				break;
			}
		}
	}
	}
	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);
		
		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=Constants.SCREENSHOT_FILEPATH+filename+getTimeStemp()+".png";
		
		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
		return picBytes;
	}

	


	public static void TakesScreenshotDataProvider(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/HRMS/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getTimeStemp() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}
}
		
	
	

		