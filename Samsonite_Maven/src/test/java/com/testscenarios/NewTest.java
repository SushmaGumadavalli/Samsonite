package com.testscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	@Test
	public void f() {
		//WebDriver driver;
		WebDriverManager.firefoxdriver().version("73").setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://fb.com");

		System.out.println(" ####### My Jenkins Sample Run  program-----");
	}
}
