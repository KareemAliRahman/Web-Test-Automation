

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

public class Sqstest_usecase1 {

	@Test
	public void test1() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\elsherbina\\Desktop\\Selenium Project\\IEDriverServer_X32_2.53.1\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
//	    FirefoxProfile firefoxProfile = new FirefoxProfile();
//	    firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
//		WebDriver driver = new FirefoxDriver(firefoxProfile);
		driver.get("https://www.sqs.com/eg/index.php");

		Thread.sleep(1000);
		WebElement element = (WebElement) driver.findElement(By.linkText("Training"));
		((WebElement) element).click();
		
//		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().contains("trusted");
//            }
//        });
//		
		
	
		Thread.sleep(10000);
//		element = (WebElement) driver.findElement(By.partialLinkText("More courses"));
		driver.findElement(By.linkText("More courses >>")).sendKeys(Keys.ENTER);
//		element = (WebElement) driver.findElement(By.className("btn"));
//		((WebElement) element).click();
		
//		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//             return d.getTitle().toLowerCase().contains("courses");
//            }
//        });
		
		Thread.sleep(1000);

		element = (WebElement) driver.findElement(By.linkText("IREB-CPRE Foundation Level"));
		((WebElement) element).click();
//		
//		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().contains("ireb");
//            }
//        });
		
		Thread.sleep(1000);
		
		element = driver.findElement(By.name("NumberOfAttendees"));
		element.sendKeys("1");
		
		element = driver.findElement(By.name("Surname"));
		element.sendKeys("Kassem");
		
		element = driver.findElement(By.name("FirstName"));
		element.sendKeys("Riham");
		
		element = driver.findElement(By.name("Company"));
		element.sendKeys("SQS");
		
		element = driver.findElement(By.name("JobTitle"));
		element.sendKeys("Junior Test Expert");
		
		element = driver.findElement(By.name("Email"));
		element.sendKeys("riham.kassem@sqs.com");
		
		element = driver.findElement(By.name("Telephone"));
		element.sendKeys("1234567890");
		
		element = driver.findElement(By.name("Street"));
		element.sendKeys("El Nasr Street");
		
		element = driver.findElement(By.name("PostalCode"));
		element.sendKeys("00202");
		
		element = driver.findElement(By.name("City"));
		element.sendKeys("Cairo");
		
		element = driver.findElement(By.name("Country"));
		element.sendKeys("Egypt");
		
		element = driver.findElement(By.name("Message"));
		element.sendKeys("I am looking forward to attending this course ... Riham Kassem");
		
		
        
//		element = driver.findElement(By.name("NumberOfAttendees"));
//		Actions builder = new Actions(driver);
//		Actions seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "1");
//		seriesOfActions.perform();

//		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().contains("ireb");
//            }
//        });
		
		
//		Thread.sleep(1000);
//
//		element = driver.findElement(By.name("Surname"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Kassem");
//		seriesOfActions.perform();
//		
//		Thread.sleep(1000);
//
//		element = driver.findElement(By.name("FirstName"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Riham");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("Company"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "SQS");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("JobTitle"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Junior Test Expert");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("Email"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "riham.kassem@sqs.com");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("Telephone"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "1234567890");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("Street"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "El Nasr Street");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("PostalCode"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "00202");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("City"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Cairo");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("Country"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Egypt");
//		seriesOfActions.perform();
//
//		element = driver.findElement(By.name("Message"));
//		seriesOfActions = builder.moveToElement(element).click().sendKeys(element,
//				"I am looking forward to attending this course ... Riham Kassem");
//		seriesOfActions.perform();
//
		element = driver.findElement(By.name("terms_conditions"));
		if (!element.isSelected()) {
			element.click();
		}

		element = driver.findElement(By.name("Datenschutz"));
		if (!element.isSelected()) {
			element.click();
		}
		
		Thread.sleep(2000);

		element = (WebElement) driver.findElement(By.name("reset"));
		((WebElement) element).click();

		Thread.sleep(1000);

		driver.close();

	}

@Test
public void test2() throws InterruptedException {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	System.setProperty("webdriver.ie.driver",
			"C:\\Users\\elsherbina\\Desktop\\Selenium Project\\IEDriverServer_X32_2.53.1\\IEDriverServer.exe");
	//WebDriver driver = new InternetExplorerDriver();
    FirefoxProfile firefoxProfile = new FirefoxProfile();
    firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
	WebDriver driver = new FirefoxDriver(firefoxProfile);
	driver.get("https://www.sqs.com/eg/index.php");
	//driver.get("https://www.sqs.com/en/academy/courses-a-z.php");

	Thread.sleep(1000);
	WebElement element = (WebElement) driver.findElement(By.linkText("Training"));
	((WebElement) element).click();
	
	Thread.sleep(10000);
//	element = (WebElement) driver.findElement(By.partialLinkText("More courses"));
	driver.findElement(By.linkText("More courses >>")).sendKeys(Keys.ENTER);
//	element = (WebElement) driver.findElement(By.className("btn"));
//	((WebElement) element).click();
	
//	(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d) {
//         return d.getTitle().toLowerCase().contains("courses");
//        }
//    });
	
	Thread.sleep(1000);

	element = (WebElement) driver.findElement(By.linkText("IREB-CPRE Foundation Level"));
	((WebElement) element).click();
//	
//	(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d) {
//            return d.getTitle().toLowerCase().contains("ireb");
//        }
//    });
	
	Thread.sleep(1000);
	
	element = driver.findElement(By.name("NumberOfAttendees"));
	element.sendKeys("1");
	
	element = driver.findElement(By.name("Surname"));
	element.sendKeys("Kassem");
	
	element = driver.findElement(By.name("FirstName"));
	element.sendKeys("Riham");
	
	element = driver.findElement(By.name("Company"));
	element.sendKeys("SQS");
	
	element = driver.findElement(By.name("JobTitle"));
	element.sendKeys("Junior Test Expert");
	
	element = driver.findElement(By.name("Email"));
	element.sendKeys("riham.kassem@sqs.com");
	
	element = driver.findElement(By.name("Telephone"));
	element.sendKeys("1234567890");
	
	element = driver.findElement(By.name("Street"));
	element.sendKeys("El Nasr Street");
	
	element = driver.findElement(By.name("PostalCode"));
	element.sendKeys("00202");
	
	element = driver.findElement(By.name("City"));
	element.sendKeys("Cairo");
	
	element = driver.findElement(By.name("Country"));
	element.sendKeys("Egypt");
	
	element = driver.findElement(By.name("Message"));
	element.sendKeys("I am looking forward to attending this course ... Riham Kassem");
	
	
    
//	element = driver.findElement(By.name("NumberOfAttendees"));
//	Actions builder = new Actions(driver);
//	Actions seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "1");
//	seriesOfActions.perform();

//	(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d) {
//            return d.getTitle().toLowerCase().contains("ireb");
//        }
//    });
	
	
//	Thread.sleep(1000);
//
//	element = driver.findElement(By.name("Surname"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Kassem");
//	seriesOfActions.perform();
//	
//	Thread.sleep(1000);
//
//	element = driver.findElement(By.name("FirstName"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Riham");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Company"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "SQS");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("JobTitle"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Junior Test Expert");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Email"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "riham.kassem@sqs.com");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Telephone"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "1234567890");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Street"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "El Nasr Street");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("PostalCode"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "00202");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("City"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Cairo");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Country"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Egypt");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Message"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element,
//			"I am looking forward to attending this course ... Riham Kassem");
//	seriesOfActions.perform();
//
	element = driver.findElement(By.name("terms_conditions"));
	if (!element.isSelected()) {
		element.click();
	}

	element = driver.findElement(By.name("Datenschutz"));
	if (!element.isSelected()) {
		element.click();
	}
	
	Thread.sleep(2000);

	element = (WebElement) driver.findElement(By.name("reset"));
	((WebElement) element).click();

	Thread.sleep(1000);
	driver.quit();

}

@Test
public void test3() throws InterruptedException {
	
//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\geckodriver-v0.11.1-win64\\geckodriver.exe");
//	System.setProperty("webdriver.ie.driver",
//			"C:\\Users\\elsherbina\\Desktop\\Selenium Project\\IEDriverServer_X32_2.53.1\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\elsherbina\\Desktop\\Selenium Project\\ChromeDriver_win32_2.25\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	//WebDriver driver = new InternetExplorerDriver();
    //FirefoxProfile firefoxProfile = new FirefoxProfile();
    //firefoxProfile.setPreference("reader.parse-on-load.enabled",true);
	//WebDriver driver = new FirefoxDriver(firefoxProfile);
	driver.get("https://www.sqs.com/eg/index.php");
	//driver.get("https://www.sqs.com/en/academy/courses-a-z.php");

	Thread.sleep(1000);
	WebElement element = (WebElement) driver.findElement(By.linkText("Training"));
	((WebElement) element).click();
	
	Thread.sleep(10000);
//	element = (WebElement) driver.findElement(By.partialLinkText("More courses"));
	driver.findElement(By.linkText("More courses >>")).sendKeys(Keys.ENTER);
//	element = (WebElement) driver.findElement(By.className("btn"));
//	((WebElement) element).click();
	
//	(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d) {
//         return d.getTitle().toLowerCase().contains("courses");
//        }
//    });
	
	Thread.sleep(1000);

	element = (WebElement) driver.findElement(By.linkText("IREB-CPRE Foundation Level"));
	((WebElement) element).click();
//	
//	(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d) {
//            return d.getTitle().toLowerCase().contains("ireb");
//        }
//    });
	
	Thread.sleep(1000);
	
	element = driver.findElement(By.name("NumberOfAttendees"));
	element.sendKeys("1");
	
	element = driver.findElement(By.name("Surname"));
	element.sendKeys("Kassem");
	
	element = driver.findElement(By.name("FirstName"));
	element.sendKeys("Riham");
	
	element = driver.findElement(By.name("Company"));
	element.sendKeys("SQS");
	
	element = driver.findElement(By.name("JobTitle"));
	element.sendKeys("Junior Test Expert");
	
	element = driver.findElement(By.name("Email"));
	element.sendKeys("riham.kassem@sqs.com");
	
	element = driver.findElement(By.name("Telephone"));
	element.sendKeys("1234567890");
	
	element = driver.findElement(By.name("Street"));
	element.sendKeys("El Nasr Street");
	
	element = driver.findElement(By.name("PostalCode"));
	element.sendKeys("00202");
	
	element = driver.findElement(By.name("City"));
	element.sendKeys("Cairo");
	
	element = driver.findElement(By.name("Country"));
	element.sendKeys("Egypt");
	
	element = driver.findElement(By.name("Message"));
	element.sendKeys("I am looking forward to attending this course ... Riham Kassem");
	
	
    
//	element = driver.findElement(By.name("NumberOfAttendees"));
//	Actions builder = new Actions(driver);
//	Actions seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "1");
//	seriesOfActions.perform();

//	(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
//        public Boolean apply(WebDriver d) {
//            return d.getTitle().toLowerCase().contains("ireb");
//        }
//    });
	
	
//	Thread.sleep(1000);
//
//	element = driver.findElement(By.name("Surname"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Kassem");
//	seriesOfActions.perform();
//	
//	Thread.sleep(1000);
//
//	element = driver.findElement(By.name("FirstName"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Riham");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Company"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "SQS");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("JobTitle"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Junior Test Expert");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Email"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "riham.kassem@sqs.com");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Telephone"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "1234567890");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Street"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "El Nasr Street");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("PostalCode"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "00202");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("City"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Cairo");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Country"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element, "Egypt");
//	seriesOfActions.perform();
//
//	element = driver.findElement(By.name("Message"));
//	seriesOfActions = builder.moveToElement(element).click().sendKeys(element,
//			"I am looking forward to attending this course ... Riham Kassem");
//	seriesOfActions.perform();
//
	element = driver.findElement(By.name("terms_conditions"));
	if (!element.isSelected()) {
		element.click();
	}

	element = driver.findElement(By.name("Datenschutz"));
	if (!element.isSelected()) {
		element.click();
	}
	
	Thread.sleep(2000);

	element = (WebElement) driver.findElement(By.name("reset"));
	((WebElement) element).click();

	Thread.sleep(1000);
	driver.quit();

}
}