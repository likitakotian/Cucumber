package com.test.TestCucumber;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjectModel.AddCustomerPom;
import pageObjectModel.LoginPOM;

public class ConfigFile {

	public WebDriver driver;
	public Properties properties;
	

	public void initializeWebDriver() throws IOException {
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/resources/data.properties");
		properties.load(fileInputStream);
		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sagarliki/Downloads/chromedriver");
			 driver = new ChromeDriver();
			if (browserName.contains("headless")) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("headless");
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			 driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "");
		}
	}

	public WebDriver getInitializedDriver() {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			return driver;
		} else {
			throw new NullPointerException("driver is null");
		}
	}

	public String getPartialScreenShot(WebElement fail, String testcaseName) throws IOException {
		File src = fail.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "/reports/" + testcaseName + ".png";
		FileUtils.copyFile(src, new File(destinationPath));
		return destinationPath;
	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
		FileUtils.copyFile(src, new File(destinationPath));
		return destinationPath;
	}
	 public static String randomString() {
		 String generatedString = RandomStringUtils.randomAlphabetic(5);
		 return generatedString;
	 }

}
