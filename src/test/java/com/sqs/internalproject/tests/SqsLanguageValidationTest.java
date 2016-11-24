package com.sqs.internalproject.tests;

import static org.junit.Assert.*;

import org.apache.tika.language.LanguageIdentifier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import com.sqs.internalproject.pageobjects.SqsHomePage;
import com.sqs.internalproject.pageobjects.SqsHomePageMobile;

import commonUtils.SeleniumTestUtils;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

@RunWith(JUnitParamsRunner.class)
public class SqsLanguageValidationTest {
	
	private WebDriver webDriver;
	private String pageTitle = "SQS ist der weltweit führende Spezialist für Software-Qualität.";
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/test/resources/SeleniumWebDrivers/ChromeDriver_win32_2.25/chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "src/test/resources/SeleniumWebDrivers/IEDriverServer_Win32_3.0.0/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "src/test/resources/SeleniumWebDrivers/geckodriver-v0.11.1-win64/geckodriver.exe");
	}

	
	@Test
	//@FileParameters("src/test/resources/com/sqs/internalproject/sqsLanguageValidationDesktopTest.csv")
	@Parameters({"firefox, Germany, de"})
	@TestCaseName("sqsLanguageValidationDesktopTest - on: {0} with Country: {1} and Language: {2}")
	public void sqsLanguageValidationDesktopTest(String driver, String country, String lang){
		webDriver = SeleniumTestUtils.getDriver(driver);
		
		webDriver.get("http://www.sqs.com");
		
		//create SQSHomePage and intialize webElements in it
		SqsHomePage sqsHome = PageFactory.initElements(webDriver, SqsHomePage.class);
		
		sqsHome.chooseCountry(country);
		
		assertTrue("Chosing Country does not change langauge.", webDriver.getTitle().equals(pageTitle));
		
		//get random text from page to be used to detect lanaguage
		LanguageIdentifier identifier = new LanguageIdentifier(sqsHome.getTextFromSQSPage());
		String language = identifier.getLanguage();
		
		assertTrue("Not expected language", language.equals(lang));
	}
	
	@Test
	@FileParameters("src/test/resources/com/sqs/internalproject/sqsLanguageValidationMobileTest.csv")
//	@Parameters({"samsung galaxy s3, Germany, de"})
	@TestCaseName("sqsLanguageValidationMobileTest - on: {0} with Country: {1} and Language: {2}")
	public void sqsLanguageValidationMobileTest(String driver, String country, String lang){
		webDriver = SeleniumTestUtils.getDriver(driver);
		
		webDriver.get("http://www.sqs.com");
		
		//create SQSHomePage and intialize webElements in it
		SqsHomePageMobile sqsHome = PageFactory.initElements(webDriver, SqsHomePageMobile.class);
		
		sqsHome.chooseCountry(country);
		
		assertTrue("Chosing Country does not change langauge.", webDriver.getTitle().equals(pageTitle));
		
		//get random text from page to be used to detect lanaguage
		LanguageIdentifier identifier = new LanguageIdentifier(sqsHome.getTextFromSQSPage());
		String language = identifier.getLanguage();
		
		assertTrue("Not expected language", language.equals(lang));
	}
	
	@Test
	//@FileParameters("src/test/resources/com/sqs/internalproject/sqsLanguageValidationAndroidTest.csv")
	@Parameters({"chrome, Germany, de"})
	@TestCaseName("sqsLanguageValidationAndroidTest - on: {0} with Country: {1} and Language: {2}")
	public void sqsLanguageValidationAndroidTest(String driver, String country, String lang){
		webDriver = SeleniumTestUtils.getDriver(driver);
		
		webDriver.get("http://www.sqs.com");
		
		//create SQSHomePage and intialize webElements in it
		SqsHomePage sqsHome = PageFactory.initElements(webDriver, SqsHomePage.class);
		
		sqsHome.chooseCountry(country);
		
		assertTrue("Chosing Country does not change langauge.", webDriver.getTitle().equals(pageTitle));
		
		//get random text from page to be used to detect lanaguage
		LanguageIdentifier identifier = new LanguageIdentifier(sqsHome.getTextFromSQSPage());
		String language = identifier.getLanguage();
		
		assertTrue("Not expected language", language.equals(lang));
	}
	
	@After
	public void afterTest(){
		webDriver.quit();
	}
}
