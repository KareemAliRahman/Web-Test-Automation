import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

import TestCategories.ChromeTest;

import org.openqa.selenium.support.ui.Select;

public class Sqstest_usecase2 {

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/SeleniumWebDrivers/ChromeDriver_win32_2.25/chromedriver.exe");

		System.setProperty("webdriver.gecko.driver",
				"src/main/resources/SeleniumWebDrivers/geckodriver-v0.11.1-win64/geckodriver.exe");
		System.setProperty("webdriver.ie.driver",
				"src/main/resources/SeleniumWebDrivers/IEDriverServer_X32_2.53.1/IEDriverServer.exe");
	}

	@Test
	public void test_IE() throws InterruptedException {

		// WebDriver driver = new InternetExplorerDriver();
		// FirefoxProfile firefoxProfile = new FirefoxProfile();
		// firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
		// WebDriver driver = new FirefoxDriver(firefoxProfile);
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.sqs.com/eg/index.php");
		driver.manage().window().maximize();

		// WebElement element = (WebElement)
		// driver.findElement(By.linkText("Egypt"));
		// ((WebElement) element).click();

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("Egypt"))).perform();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElements(By.linkText("Germany")).size() > 0;
			}
		});
		driver.findElement(By.linkText("Germany")).click();
		;

		// driver.findElement(By.linkText("Germany")).sendKeys(Keys.ENTER);

		// Thread.sleep(10000);
		//
		// element = (WebElement) driver.findElement(By.linkText("�ber SQS"));
		// ((WebElement) element).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().startsWith("SQS ist der weltweit");
			}
		});

		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("�ber SQS"))).perform();
		driver.findElement(By.linkText("Unternehmensprofil")).click();
		;

		// for(WebElement e:
		// driver.findElements(By.linkText("Unternehmensprofil"))){
		// System.out.println(e.getAttribute("href"));
		// System.out.println(e.getText());
		// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		// }
		//// driver.findElement(By.linkText("Unternehmensprofil")).sendKeys(Keys.ENTER);
		//
		// Thread.sleep(1000);
		driver.findElement(By.linkText("Unternehmenspr�sentation")).sendKeys(Keys.ENTER);

		// Thread.sleep(1000);

		driver.quit();

	}

	@Test
	@Category(ChromeTest.class)
	public void test_Chrome() throws InterruptedException {

		// WebDriver driver = new InternetExplorerDriver();
		// FirefoxProfile firefoxProfile = new FirefoxProfile();
		// firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
		// WebDriver driver = new FirefoxDriver(firefoxProfile);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sqs.com/eg/index.php");
		driver.manage().window().maximize();

		// WebElement element = (WebElement)
		// driver.findElement(By.linkText("Egypt"));
		// ((WebElement) element).click();

		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("Egypt"))).perform();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElements(By.linkText("Germany")).size() > 0;
			}
		});
		driver.findElement(By.linkText("Germany")).click();
		;

		// driver.findElement(By.linkText("Germany")).sendKeys(Keys.ENTER);

		// Thread.sleep(10000);
		//
		// element = (WebElement) driver.findElement(By.linkText("�ber SQS"));
		// ((WebElement) element).click();

		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.linkText("�ber SQS"))).perform();
		driver.findElement(By.linkText("Unternehmensprofil")).click();
		;

		// for(WebElement e:
		// driver.findElements(By.linkText("Unternehmensprofil"))){
		// System.out.println(e.getAttribute("href"));
		// System.out.println(e.getText());
		// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		// }
		//// driver.findElement(By.linkText("Unternehmensprofil")).sendKeys(Keys.ENTER);
		//
		// Thread.sleep(1000);
		driver.findElement(By.linkText("Unternehmenspr�sentation")).sendKeys(Keys.ENTER);

		// Thread.sleep(1000);

		driver.quit();

	}

	@Test
	public void test_Firefox() throws InterruptedException {

		// WebDriver driver = new InternetExplorerDriver();
		// FirefoxProfile firefoxProfile = new FirefoxProfile();
		// firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new ChromeDriver();
		driver.get("https://www.sqs.com/eg/index.php");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.linkText("Egypt"));
		actions.moveToElement(menuHoverLink);

		WebElement subLink = driver.findElement(By.linkText("Germany"));
//		WebElement subLink = driver.findElement(By.cssSelector("#metaNav > ul > li.country > div > div.wrapper > ul > li:nth-child(5) > a"));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
		
//		WebElement element = (WebElement) driver.findElement(By.linkText("Egypt"));
//		((WebElement) element).click();
		
//		 element = (WebElement) driver.findElement(By.linkText("Germany"));
//		((WebElement) element).click();

		// Actions builder = new Actions(driver);
		// builder.moveToElement(driver.findElement(By.linkText("Egypt"))).perform();
		// (new WebDriverWait(driver, 10)).until(new
		// ExpectedCondition<Boolean>() {
		// public Boolean apply(WebDriver d) {
		// return d.findElements(By.linkText("Germany")).size() > 0;
		// }
		// });
		// driver.findElement(By.linkText("Germany")).click();
		// ;

		// driver.findElement(By.linkText("Germany")).sendKeys(Keys.ENTER);

		// Thread.sleep(10000);
		//
		// element = (WebElement) driver.findElement(By.linkText("�ber SQS"));
		// ((WebElement) element).click();

		// builder = new Actions(driver);
		// builder.moveToElement(driver.findElement(By.linkText("�ber
		// SQS"))).perform();
		// driver.findElement(By.linkText("Unternehmensprofil")).click();
		// ;

		// for(WebElement e:
		// driver.findElements(By.linkText("Unternehmensprofil"))){
		// System.out.println(e.getAttribute("href"));
		// System.out.println(e.getText());
		// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		// }
		//// driver.findElement(By.linkText("Unternehmensprofil")).sendKeys(Keys.ENTER);
		//
		// Thread.sleep(1000);
		driver.findElement(By.linkText("Unternehmenspr�sentation")).sendKeys(Keys.ENTER);

		// Thread.sleep(1000);

		driver.quit();

	}
}
