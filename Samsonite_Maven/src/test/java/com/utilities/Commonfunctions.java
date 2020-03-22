package com.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonfunctions extends Staticvariables {

	/***************** sendkeys *************************/
	public void sendKeysByAnyLocator(By locator, String inputdata) {

		WebElement element = driver.findElement(locator);
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					element.clear();
					element.sendKeys(inputdata);
				} else {
					System.out.println("element is NOT enabled state *****");
				}

			} else {
				System.out.println("element is NOT displayed in DOM **********");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/***************** Click *************************/
	public void clickByAnyLocator(By locator) {

		WebElement element = driver.findElement(locator);
		try {
			if (element.isDisplayed()) {
				if (element.isEnabled()) {
					element.click();
					implicitwait();
				} else {
					System.out.println("element is NOT enabled state *****");
				}

			} else {
				System.out.println("element is NOT displayed in DOM **********");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/************************ Chrome browser launch *****************/
	public void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().version("80").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().version("73").setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	/************************** Implicit Wait *************************/

	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/************************** Validation of Text ********************/
	public void validateTextMsg(By locator, String expectedText) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			String actualText = element.getText();
			Assert.assertEquals(actualText, expectedText);
			System.out.println("Error messages are matching *************");
		} else {
			System.out.println("Text messages are NOT matching, Please check onece****************");
		}

	}
	
	/**************** Time Stamp *******************/
	public String timeStampasString() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	public String TimeStampSQLasString() {
		java.util.Date date = new java.util.Date();
		String timeStamp = new Timestamp(date.getTime()).toString();
		return timeStamp;
	}

	public String TimeStamp2asStringwithAMPM() {
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(Calendar.getInstance().getTime());
		return timeStamp;
	}

	public String DateTimeOfUK() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		// Use Europe/London time zone to format the date in
		df.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String timeStamp = df.format(date);
		return timeStamp;
	}

	public void screenshotOnPassFail(ITestResult testResult) throws IOException {
		Staticvariables.ClassName = testResult.getTestClass().getName().trim();
		Staticvariables.MethodName = testResult.getName().trim();
		String ClsNmMtdNm = Staticvariables.ClassName + "_" + Staticvariables.MethodName + "_";
		Staticvariables.ScreenshotsPath = "./screenshots/";
		if (testResult.getStatus() != ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println("ClsNmMtdNm: " + ClsNmMtdNm + "; TimeStampasString" + timeStampasString());
			FileUtils.copyFile(scrFile,
					new File(ScreenshotsPath + "Pass_" + ClsNmMtdNm + timeStampasString() + ".jpg"));
		}
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println("ClsNmMtdNm: " + ClsNmMtdNm + "; TimeStampasString" + timeStampasString());
			FileUtils.copyFile(scrFile,
					new File(ScreenshotsPath + "Fail_" + ClsNmMtdNm + timeStampasString() + ".jpg"));
		}
	}


}
