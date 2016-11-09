import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExampleSelTest {

	@Test
	public void test() {
    	System.setProperty("webdriver.ie.driver", "src\\main\\resources\\SeleniumWebDrivers\\IEDriverServer_Win32_3.0.0\\IEDriverServer.exe");
    	WebDriver driver = new InternetExplorerDriver();
    	//driver.manage().window().setPosition(new Point(750, 1334));
    	//driver.manage().window().setSize(new Dimension(500, 500));
        
    	driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Nautella!");
        element.submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return d.getTitle().toLowerCase().startsWith("nautella!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        assertEquals(driver.getTitle().toLowerCase().split(" ")[0],"nautella!");
        driver.quit();

	}
	
	@Test
	public void test1() {
    	System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\SeleniumWebDrivers\\geckodriver-v0.11.1-win64\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();

        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Nautella!");
        element.submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return d.getTitle().toLowerCase().startsWith("nautella!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        assertEquals(driver.getTitle().toLowerCase().split(" ")[0],"nautella!");
        driver.quit();
	}
	
	@Test
	public void testGrid() {
	   	System.setProperty("webdriver.ie.driver", "src\\main\\resources\\SeleniumWebDrivers\\IEDriverServer_x32_2.53.1\\IEDriverServer.exe");

	   	DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	   	//DesiredCapabilities cap = DesiredCapabilities.edge();
//	   	cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//	   	cap.setBrowserName("internet explorer");
//	   	cap.setBrowserName("");
//	   	cap.
	   	WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.34.40:5555/wd/hub"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Nautella!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return d.getTitle().toLowerCase().startsWith("nautella!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        //assertTrue( driver.getTitle().toLowerCase().startsWith("nautella!"));
        assertEquals(driver.getTitle().toLowerCase().split(" ")[0],"nautella!");
        driver.quit();
	}

}
