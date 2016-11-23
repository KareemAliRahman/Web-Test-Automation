package com.example.sqs.tests;

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

import com.example.sqs.pom.SQSHomePage;
import com.example.sqs.pom.SQSSearchPage;

import commonUtils.SeleniumTestUtils;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SQSSearchingTest {
	private WebDriver webDriver;
	
//    @Parameters(name = "{index}:SQSSearchingTest - {0}")
//    public static Collection<String> data() {
//        return Arrays.asList(new String[] {"services", "technologies"});
//    }
//    
//	@Parameter
//	public String keyword;
//	
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

//	@Before
//	public void beforeTest() {
//		driver = new ChromeDriver();
//	}

	@Test
	//@FileParameters("src/test/resources/com/example/sqs/tests/SQSSearchingTest.csv")
	@Parameters({ "chrome, technologies"})
	@TestCaseName("SQSSearchingTest - on: {0} with keyword: {1}")
	public void SQSSearchingTest(String driver, String keyword){
		//WebDriver webDriver = SeleniumTestUtils.getDriver(driver);
		System.out.println("############################################3");
		System.out.println(driver + "         :        " + keyword);
		System.out.println("############################################3");
		
		if (driver.equals("ie")) {
			webDriver = new InternetExplorerDriver();
		}else {
			webDriver= new ChromeDriver();
		}
		
		webDriver.get("http://www.sqs.com");
		
		SQSHomePage sqsHome = PageFactory.initElements(webDriver, SQSHomePage.class);
		
		sqsHome.searchFor(keyword);
		
		assertTrue("Unexpected page. got page title:" + webDriver.getCurrentUrl(),
				webDriver.getCurrentUrl().contains("search_item=" + keyword));
		
		SQSSearchPage sqsSearch = PageFactory.initElements(webDriver, SQSSearchPage.class);
		
		sqsSearch.showNextSearchPage();
		
		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl())!= HttpURLConnection.HTTP_NOT_FOUND);
		
		sqsSearch.showPreviousSearchPage();
		
		assertTrue("Page is not found", URLResponse(webDriver.getCurrentUrl())!= HttpURLConnection.HTTP_NOT_FOUND);
		
	}

	@After
	public void afterTest(){
		webDriver.close();
	}
	
	public static int URLResponse(String URLName){
	    try {
	      HttpURLConnection.setFollowRedirects(false);
	      HttpURLConnection con =
	         (HttpURLConnection) new URL(URLName).openConnection();
	      con.setRequestMethod("HEAD");
	      return con.getResponseCode();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	       return 0;
	    }
	}

}
