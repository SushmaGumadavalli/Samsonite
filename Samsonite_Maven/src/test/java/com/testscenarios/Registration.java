package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import com.utilities.Staticvariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class Registration extends Staticvariables {
	Commonfunctions cfn = new Commonfunctions();
	Locators obj = new Locators();

	@Test
	public void TC_001() throws Exception {
		cfn.firefoxBrowserLaunch();
		// get the data from property file
		FileInputStream fi = new FileInputStream("./testdata/testdata.properties");
		Properties prop = new Properties();
		prop.load(fi);

		// URL
		driver.navigate().to(prop.getProperty("baseURL"));
		// click on login link
		cfn.clickByAnyLocator(obj.Login_button);
		cfn.clickByAnyLocator(obj.Login_CreateNewAccount_button);
		Thread.sleep(5000);
		// Click on submit button without enter any details
		cfn.clickByAnyLocator(obj.CreateAnAccount_CreateNewAccount_button);
		
		
		
		cfn.validateTextMsg(obj.CreateAnAccount_Firstname_Error_Msg, prop.getProperty("FirstNameErrMsg"));
		cfn.validateTextMsg(obj.CreateAnAccount_Lastname_Error_Msg, prop.getProperty("LastNameErrMsg"));
		cfn.validateTextMsg(obj.CreateAnAccount_Email_Error_Msg, prop.getProperty("EmailErrMsg"));
		cfn.validateTextMsg(obj.CreateAnAccount_ConfirmEmail_Error_Msg, prop.getProperty("ConfirmEmailErrMsg"));
		cfn.validateTextMsg(obj.CreateAnAccount_Password_Error_Msg, prop.getProperty("PasswordErrMsg"));
		cfn.validateTextMsg(obj.CreateAnAccount_Confirmpassword_Error_Msg, prop.getProperty("ConfirmPasswordErrMsg"));
		// Reresh the screen
		driver.navigate().refresh();
		Thread.sleep(5000);
		// Click on Continue button on confirmation alert
		System.out.println("Confirmation Alert Text is: "+driver.switchTo().alert().getText());		
		driver.switchTo().alert().accept();
		Thread.sleep(5000);	
		
		// enter valid data and submit
		cfn.sendKeysByAnyLocator(obj.CreateAnAccount_FirstName_EditBox, prop.getProperty("FirstName"));
		cfn.sendKeysByAnyLocator(obj.CreateAnAccount_LastName_EditBox, prop.getProperty("LastName"));
		cfn.sendKeysByAnyLocator(obj.CreateAnAccount_Email_EditBox, prop.getProperty("Email"));
		cfn.sendKeysByAnyLocator(obj.CreateAnAccount_ConfirmEmail_EditBox, prop.getProperty("ConfirmEmail"));
		cfn.sendKeysByAnyLocator(obj.CreateAnAccount_Password_EditBox, prop.getProperty("Password"));
		cfn.sendKeysByAnyLocator(obj.CreateAnAccount_ConfirmPassword_EditBox, prop.getProperty("ConfirmPassword"));
		// cfn.clickByAnyLocator(obj.Login_CreateNewAccount_button);

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		cfn.screenshotOnPassFail(testResult);
		cfn.implicitwait();

	}

	@BeforeClass
	public void beforeClass() {
		cfn.firefoxBrowserLaunch();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
