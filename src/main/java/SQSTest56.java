import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
    	System.out.println(driver.getTitle().toLowerCase());
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
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}
	

}
