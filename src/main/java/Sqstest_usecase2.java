import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class Sqstest_usecase2{

	@Test
	public void test_IE() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\elsherbina\\Desktop\\Selenium Project\\IEDriverServer_X32_2.53.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
//	    FirefoxProfile firefoxProfile = new FirefoxProfile();
//	    firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
//		WebDriver driver = new FirefoxDriver(firefoxProfile);

//		driver.get("https://www.sqs.com/eg/index.php");
		
		driver.get("https://www.sqs.com/eg/index.php");

		WebElement element = (WebElement) driver.findElement(By.linkText("Egypt"));
		((WebElement) element).click();
		
		driver.findElement(By.linkText("Germany")).sendKeys(Keys.ENTER);
		
		Thread.sleep(10000);
		
		element = (WebElement) driver.findElement(By.linkText("Über SQS"));
		((WebElement) element).click();
		
		Thread.sleep(100);

		driver.findElement(By.linkText("Unternehmensprofil")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Unternehmenspräsentation")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);

driver.quit();

	}
	
	@Test	
public void test_Chrome() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\ChromeDriver_win32_2.25\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	System.setProperty("webdriver.ie.driver",
			"C:\\Users\\elsherbina\\Desktop\\Selenium Project\\IEDriverServer_X32_2.53.1\\IEDriverServer.exe");
//	WebDriver driver = new InternetExplorerDriver();
//    FirefoxProfile firefoxProfile = new FirefoxProfile();
//    firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
//	WebDriver driver = new FirefoxDriver(firefoxProfile);
	
	driver.get("https://www.sqs.com/eg/index.php");

	WebElement element = (WebElement) driver.findElement(By.linkText("Egypt"));
	((WebElement) element).click();
	
	driver.findElement(By.linkText("Germany")).sendKeys(Keys.ENTER);
	
	Thread.sleep(10000);
	
	element = (WebElement) driver.findElement(By.linkText("Über SQS"));
	((WebElement) element).sendKeys(Keys.ENTER);
	
	driver.findElement(By.linkText("Unternehmensprofil")).sendKeys(Keys.ENTER);
	
	Thread.sleep(1000);
	driver.findElement(By.linkText("Unternehmenspräsentation")).sendKeys(Keys.ENTER);
	
	Thread.sleep(1000);

driver.quit();

}
}