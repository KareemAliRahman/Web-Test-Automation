package com.example.sqs.tests;

import static org.junit.Assert.*;

import org.apache.tika.language.LanguageIdentifier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.example.sqs.pom.SQSHomePage;

public class SQSLanguageValidationTest {
	
	private WebDriver driver;
	String country = "Germany";
	String pageTitle = "SQS ist der weltweit führende Spezialist für Software-Qualität.";
	String lang = "de";
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/SeleniumWebDrivers/ChromeDriver_win32_2.25/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "src/test/resources/SeleniumWebDrivers/IEDriverServer_Win32_3.0.0/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/SeleniumWebDrivers/geckodriver-v0.11.1-win64/geckodriver.exe");
	}
	
	@Before
	public void beforeTest(){
		driver = new FirefoxDriver();
	}
	
	@Test
	@Ignore
	public void sqsLanguageValidationTest(){
		driver.get("http://www.sqs.com");
		
		//create SQSHomePage and intialize webElements in it
		SQSHomePage sqsHome = PageFactory.initElements(driver, SQSHomePage.class);
		
		sqsHome.chooseCountry(country);
		
		assertTrue("Chosing Country does not change langauge.", driver.getTitle().equals(pageTitle));
		
		//get random text from page to be used to detect lanaguage
		LanguageIdentifier identifier = new LanguageIdentifier(sqsHome.getTextFromSQSPage());
		String language = identifier.getLanguage();
		
		assertTrue("Not expected language", language.equals(lang));
		
	}
	
	@After
	public void afterTest(){
		driver.close();
	}
}
