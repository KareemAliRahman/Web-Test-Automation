package com.sqs.internalproject.tests;

import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.apache.http.HttpResponse;
import org.apache.tika.language.LanguageIdentifier;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.omg.CORBA.INTERNAL;

import junitparams.Parameters;
import junitparams.naming.TestCaseName;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sqs.internalproject.pageobjects.SqsHomePage;
import com.sqs.internalproject.pageobjects.SqsHomePageMobile;
import com.sqs.internalproject.pageobjects.SqsSearchPage;

import commonUtils.SeleniumTestUtils;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import org.openqa.selenium.chrome.ChromeOptions;


@RunWith(JUnitParamsRunner.class)
public class SqsSearchingTest {
	private WebDriver webDriver;
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

	@Test
//	@Parameters({ "firefox,services" })
	@FileParameters("src/test/resources/com/sqs/internalproject/sqsSearchingDesktopTest.csv")
	@TestCaseName("sqsSearchingDesktopTest - on: {0} with keyword: {1}")
	public void sqsSearchingDesktopTest(String driver, String keyword) {
		webDriver = SeleniumTestUtils.getDriver(driver);
		webDriver.get("http://www.sqs.com");

		SqsHomePage sqsHome = PageFactory.initElements(webDriver, SqsHomePage.class);

		sqsHome.searchFor(keyword);

		(new WebDriverWait(webDriver, 10)).until(
				ExpectedConditions.urlToBe("https://www.sqs.com/en-group/_meta/search.php?search_item=" + keyword));
		assertTrue("Unexpected page. got page title:" + webDriver.getCurrentUrl(),
				webDriver.getCurrentUrl().contains("search_item=" + keyword));

		SqsSearchPage sqsSearch = PageFactory.initElements(webDriver, SqsSearchPage.class);

		sqsSearch.showNextSearchPage();

		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl()) != HttpURLConnection.HTTP_NOT_FOUND);

		sqsSearch.showPreviousSearchPage();

		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl()) != HttpURLConnection.HTTP_NOT_FOUND);
	}

	@Test
	@FileParameters("src/test/resources/com/sqs/internalproject/sqsSearchingMobileTest.csv")
	@TestCaseName("sqsSearchingMobileTest - on: {0} with keyword: {1}")
	public void sqsSearchingMobileTest(String driver, String keyword) {
		webDriver = SeleniumTestUtils.getDriver(driver);
		webDriver.get("http://www.sqs.com");

		SqsHomePageMobile sqsHome = PageFactory.initElements(webDriver, SqsHomePageMobile.class);

		sqsHome.searchFor(keyword);

		assertTrue("Unexpected page. got page title:" + webDriver.getCurrentUrl(),
				webDriver.getCurrentUrl().contains("search_item=" + keyword));

		SqsSearchPage sqsSearch = PageFactory.initElements(webDriver, SqsSearchPage.class);

		sqsSearch.showNextSearchPage();

		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl()) != HttpURLConnection.HTTP_NOT_FOUND);

		sqsSearch.showPreviousSearchPage();

		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl()) != HttpURLConnection.HTTP_NOT_FOUND);

	}
	
	@Test
	@Parameters({ "Android,services", "Android, technologies"})
	//@FileParameters("src/test/resources/com/sqs/internalproject/sqsSearchingAndroidTest.csv")
	@TestCaseName("sqsSearchingAndroidTest - on: {0} with keyword: {1}")
	public void sqsSearchingAndroidTest(String driver, String keyword) {
		webDriver = SeleniumTestUtils.getDriver(driver);

		webDriver.get("http://www.sqs.com");

		SqsHomePageMobile sqsHome = PageFactory.initElements(webDriver, SqsHomePageMobile.class);

		sqsHome.searchFor(keyword);

		assertTrue("Unexpected page. got page title:" + webDriver.getCurrentUrl(),
				webDriver.getCurrentUrl().contains("search_item=" + keyword));

		SqsSearchPage sqsSearch = PageFactory.initElements(webDriver, SqsSearchPage.class);

		sqsSearch.showNextSearchPage();

		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl()) != HttpURLConnection.HTTP_NOT_FOUND);

		sqsSearch.showPreviousSearchPage();

		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl()) != HttpURLConnection.HTTP_NOT_FOUND);

	}

	@After
	public void afterTest() {
		webDriver.quit();
	}

	public static int URLResponse(String URLName) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();
			con.setRequestMethod("HEAD");
			return con.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}