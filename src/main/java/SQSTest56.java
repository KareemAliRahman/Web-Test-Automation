import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import TestCategories.ChromeTest;

public class SQSTest56 {
	
	private String SQSURL = "https://www.sqs.com/en-group/";
	private static WebDriver driver;
	
	@BeforeClass
	public static void setup(){
    	System.setProperty("webdriver.ie.driver", "src\\main\\resources\\SeleniumWebDrivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
    	System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\SeleniumWebDrivers\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\SeleniumWebDrivers\\ChromeDriver_win32_2.25\\chromedriver.exe");
	}
	
	public void useCase5(WebDriver driver){
    	driver.get(SQSURL);
    	
    	WebElement we = driver.findElement(By.linkText("Sitemap"));
    	we.click();
    	//assertTrue(driver.getTitle().toLowerCase().equals("sitemap"));
    	
    	we = driver.findElement(By.xpath("//*[@id='sitemap']/ul/li/img"));
    	we.click();
    	assertTrue(we.getAttribute("src").contains("open.gif"));
    	
    	we.click();
    	assertTrue(we.getAttribute("src").contains("close.gif"));
    	
    	driver.quit();
	}
	
	public void useCase6(WebDriver driver){
		driver.get(SQSURL);
		WebElement element = driver.findElement(By.name("search_item"));
		element.sendKeys("test");
		element.submit();
//		assertTrue(driver.getTitle().toLowerCase().contains("search"));
		assertNotNull(driver.findElement(By.linkText("next >>")));
		assertTrue(driver.findElements(By.linkText("<< previous")).size() < 1);
		
		element = driver.findElement(By.linkText("next >>"));
		element.click();
		
		element = driver.findElement(By.linkText("<< previous"));
		assertNotNull(element);
		element.click();
		
		driver.quit();
	}

	@Test
	@Category(ChromeTest.class)
	public void UseCaseChrome5() {
		driver = new ChromeDriver();
		useCase5(driver);
	}
	
	@Test
	public void UseCaseFirefox5() {
		driver = new FirefoxDriver();
		useCase5(driver);
	}
	
	@Test
	public void UseCaseIE5() {
		driver = new InternetExplorerDriver();
		useCase5(driver);
	}
	
	@Test
	public void UseCaseAndroid5(){
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("androidPackage", "com.android.chrome");
		chromeOptions.put("androidDeviceSerial", "019c907d9c0a8f2b");
	   	DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		WebDriver driver = null;

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:9515"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
    	driver.get(SQSURL);
    	
    	WebElement we = driver.findElement(By.linkText("Sitemap"));
    	we.click();
    	//assertTrue(driver.getTitle().toLowerCase().equals("sitemap"));
    	
    	we = driver.findElement(By.xpath("//*[@id='sitemap']/ul/li/img"));
    	we.click();
    	assertTrue(we.getAttribute("src").contains("open.gif"));
    	
    	we.click();
    	assertTrue(we.getAttribute("src").contains("close.gif"));
    	
    	driver.quit();
	}
	
	@Test
	@Category(ChromeTest.class)
	public void UseCaseChrome6() {
		driver = new ChromeDriver();
		useCase6(driver);
	}
	
	@Test
	public void UseCaseFirefox6() {
		driver = new FirefoxDriver();
		useCase6(driver);
	}
	
	@Test
	public void UseCaseIE6() {
		driver = new InternetExplorerDriver();
		useCase6(driver);
	}
	
	@Test
	public void UseCaseAndroid6(){
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("androidPackage", "com.android.chrome");
		chromeOptions.put("androidDeviceSerial", "019c907d9c0a8f2b");
	   	DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
		WebDriver driver = null;

		try {
			driver = new RemoteWebDriver(new URL("http://localhost:9515"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.get(SQSURL);
//		JavascriptExecutor jsx = (JavascriptExecutor)driver;
//		jsx.executeScript("window.scrollBy(0,450)", "");
//		WebElement element = driver.findElement(By.name("search_item"));
		WebElement element = driver.findElement(By.xpath("//*[@id='mobileSearch']/input[1]"));

		element.sendKeys("test");
		element.submit();
//		assertTrue(driver.getTitle().toLowerCase().contains("search"));
		assertNotNull(driver.findElement(By.linkText("next >>")));
		assertTrue(driver.findElements(By.linkText("<< previous")).size() < 1);
		
		element = driver.findElement(By.linkText("next >>"));
		element.click();
		
		element = driver.findElement(By.linkText("<< previous"));
		assertNotNull(element);
		element.click();
		
		driver.quit();
	}
	
	@AfterClass
	public static void tearDown(){
		//driver.quit();
	}
	

}
