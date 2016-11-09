import static org.junit.Assert.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.WinUser.INPUT;


public class SQSTest {

	@Test
	public void test1_1() {
    	System.setProperty("webdriver.ie.driver", "src\\main\\resources\\SeleniumWebDrivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
    	WebDriver driver = new InternetExplorerDriver();
    	
    	driver.get("https://www.sqs.com/eg/index.php");
        WebElement training = driver.findElement(By.partialLinkText("Training"));
        training.click();
        assertTrue(driver.getTitle().toLowerCase().contains("trusted provider"));
        
        WebElement email = driver.findElement(By.id("buttonContactBox"));
        email.click();
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        
        WebElement Element = driver.findElement(By.xpath("//*[@id='Name']"));
        Element.sendKeys("Riham");
        Element = driver.findElement(By.xpath("//*[@id='Email']"));
        Element.sendKeys("Riham@sqs.com");
        Element = driver.findElement(By.xpath("//*[@id='Company']"));
        Element.sendKeys("SQS");
        Element = driver.findElement(By.xpath("//*[@id='Topic']"));
        Element.sendKeys("Training");
        Element = driver.findElement(By.xpath("//*[@id='Country']"));
        Element.sendKeys("Egypt");
        Element = driver.findElement(By.xpath("//*[@id='Datenschutz']"));
        Element.click();
        Element = driver.findElement(By.xpath("//*[@name='reset']"));
        Element.click();
        driver.quit();  
	}
	
	
	
	@Test
	public void test1_2() {
		System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\SeleniumWebDrivers\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
    	
    	driver.get("https://www.sqs.com/eg/index.php");
        WebElement training = driver.findElement(By.partialLinkText("Training"));
        training.click();
        assertTrue(driver.getTitle().toLowerCase().contains("trusted provider"));
        
        
        WebElement email = driver.findElement(By.id("buttonContactBox"));
        email.click();
        
        WebElement frame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame);
        
        WebElement Element = driver.findElement(By.xpath("//*[@id='Name']"));
        Element.sendKeys("Riham");
        Element = driver.findElement(By.xpath("//*[@id='Email']"));
        Element.sendKeys("Riham@sqs.com");
        Element = driver.findElement(By.xpath("//*[@id='Company']"));
        Element.sendKeys("SQS");
        Element = driver.findElement(By.xpath("//*[@id='Topic']"));
        Element.sendKeys("Training");
        Element = driver.findElement(By.xpath("//*[@id='Country']"));
        Element.sendKeys("Egypt");
        Element = driver.findElement(By.xpath("//*[@id='Datenschutz']"));
        Element.click();
        Element = driver.findElement(By.xpath("//*[@name='reset']"));
        Element.click();
        driver.quit();  
	}
	
	
	
	
}
