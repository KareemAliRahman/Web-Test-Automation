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


public class Sqstest_usecase2<IWebElement> {

	@Test
	public void test1() throws InterruptedException {
		
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
		driver.findElement(By.linkText("Unternehmensprofil")).sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Unternehmenspräsentation")).sendKeys(Keys.ENTER);

		
//		Thread.sleep(10000);
//
//		driver.findElement(By.linkText("More courses >>")).sendKeys(Keys.ENTER);
//
//		
//		Thread.sleep(1000);
//
//		element = (WebElement) driver.findElement(By.linkText("IREB-CPRE Foundation Level"));
//		((WebElement) element).click();
//
//		
//		Thread.sleep(1000);
//		
//		element = driver.findElement(By.name("NumberOfAttendees"));
//		element.sendKeys("1");
//		
//		element = driver.findElement(By.name("Surname"));
//		element.sendKeys("Kassem");
//		
//		element = driver.findElement(By.name("FirstName"));
//		element.sendKeys("Riham");
//		
//		element = driver.findElement(By.name("Company"));
//		element.sendKeys("SQS");
//		
//		element = driver.findElement(By.name("JobTitle"));
//		element.sendKeys("Junior Test Expert");
//		
//		element = driver.findElement(By.name("Email"));
//		element.sendKeys("riham.kassem@sqs.com");
//		
//		element = driver.findElement(By.name("Telephone"));
//		element.sendKeys("1234567890");
//		
//		element = driver.findElement(By.name("Street"));
//		element.sendKeys("El Nasr Street");
//		
//		element = driver.findElement(By.name("PostalCode"));
//		element.sendKeys("00202");
//		
//		element = driver.findElement(By.name("City"));
//		element.sendKeys("Cairo");
//		
//		element = driver.findElement(By.name("Country"));
//		element.sendKeys("Egypt");
//		
//		element = driver.findElement(By.name("Message"));
//		element.sendKeys("I am looking forward to attending this course ... Riham Kassem");
//		
//
//		element = driver.findElement(By.name("terms_conditions"));
//		if (!element.isSelected()) {
//			element.click();
//		}
//
//		element = driver.findElement(By.name("Datenschutz"));
//		if (!element.isSelected()) {
//			element.click();
//		}
//		
//		Thread.sleep(2000);
//
//		element = (WebElement) driver.findElement(By.name("reset"));
//		((WebElement) element).click();
//
//		Thread.sleep(1000);
//
//		driver.close();

	}
}