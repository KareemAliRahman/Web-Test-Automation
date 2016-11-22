package com.example.sqs.tests;

import static org.junit.Assert.assertTrue;

import org.apache.tika.language.LanguageIdentifier;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.sqs.pom.SQSHomePage;

public class SQSSearchingTest {
	private WebDriver driver;
	String keyword = "Germany";
	String pageTitle = "SQS ist der weltweit führende Spezialist für Software-Qualität.";

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/SeleniumWebDrivers/ChromeDriver_win32_2.25/chromedriver.exe");
		System.setProperty("webdriver.ie.driver",
				"src/test/resources/SeleniumWebDrivers/IEDriverServer_Win32_3.0.0/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver",
				"src/test/resources/SeleniumWebDrivers/geckodriver-v0.11.1-win64/geckodriver.exe");
	}

	@Before
	public void beforeTest() {
		driver = new ChromeDriver();
	}

	@Test
	public void SQSSearchingTest(){
		driver.get("http://www.sqs.com");
		
		SQSHomePage sqsHome = PageFactory.initElements(driver, SQSHomePage.class);
		
		sqsHome.searchFor(keyword);
		
		assertTrue("Unexpected page. got page title:" + driver.getCurrentUrl(),
				driver.getCurrentUrl().contains("search_item=" + keyword));
		
		
	}

	@After
	public void afterTest() throws InterruptedException {
		Thread.sleep(2500);
		driver.close();
	}

}
