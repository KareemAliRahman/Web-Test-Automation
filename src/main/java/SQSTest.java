import static org.junit.Assert.*;

import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.WinUser.INPUT;

public class SQSTest {

	@Test
	public void test_3_1() {
		System.setProperty("webdriver.ie.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
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

	// ==================================================================================================

	@Test
	public void test_3_2() {
		System.setProperty("webdriver.gecko.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.sqs.com/eg/index.php");
		WebElement training = driver.findElement(By.partialLinkText("Training"));
		training.click();
		// assertTrue(driver.getTitle().toLowerCase().contains("trusted
		// provider"));

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElements(By.id("buttonContactBox")).size() > 0;
			}
		});

		WebElement email = driver.findElement(By.id("buttonContactBox"));
		email.click();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElements(By.tagName("iframe")).size() > 0;
			}
		});

		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElements(By.xpath("//*[@id='Name']")).size() > 0;
			}
		});
		
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

	// ===============================================================================================

	@Test
	public void test_3_3() {
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\ChromeDriver_win32_2.25\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.sqs.com/eg/index.php");
		// or you can type: driver.navigate().to("https://www.sqs.com/eg/index.php");
		
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

	// ==================================================================================================

	@Test

	public void androidTest_3_4() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\ChromeDriver_win32_2.25\\chromedriver.exe");
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("https://www.sqs.com/eg/index.php");

		// WebElement Mainliste = driver.findElement(By.id("liste"));
		// Mainliste.click();
		// WebElement training =
		// driver.findElement(By.partialLinkText("Training"));
		// training.click();

		WebElement email = driver.findElement(By.id("letter"));
		email.click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElements(By.xpath("//*[@id='Name']")).size() > 0;
			}
		});

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
		Element.submit();
		driver.quit();
	}

	// ==================================================================================================

	@Test
	public void test_4_1() {
		System.setProperty("webdriver.ie.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();

		driver.get("https://www.sqs.com/eg/index.php");
		WebElement training = driver.findElement(By.partialLinkText("Contact"));
		training.click();

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

	// =================================================================================================

	@Test

	public void test_4_2() {
		System.setProperty("webdriver.gecko.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.sqs.com/eg/index.php");
		WebElement training = driver.findElement(By.partialLinkText("Contact"));
		training.click();

		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElements(By.xpath("//*[@id='Name']")).size() > 0;
			}
		});

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

	// =============================================================================================

	@Test

	public void test_4_3() {
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\ChromeDriver_win32_2.25\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.sqs.com/eg/index.php");
		WebElement training = driver.findElement(By.partialLinkText("Contact"));
		training.click();

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

	// ===========================================================================================

	@Test

	public void android_4_3() {
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\SeleniumWebDrivers\\ChromeDriver_win32_2.25\\chromedriver.exe");
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("https://www.sqs.com/eg/index.php");

		WebElement contact = driver.findElement(By.partialLinkText("Contact"));
		contact.click();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElements(By.xpath("//*[@id='Name']")).size() > 0;
			}
		});

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
		Element.submit();
		driver.quit();
	}

}
