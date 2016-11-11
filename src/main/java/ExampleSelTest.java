import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
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
   
//    	ProfilesIni profile = new ProfilesIni();
//		 
//		FirefoxProfile myprofile = profile.getProfile("profileToolsQA");
		FirefoxProfile myprofile = new FirefoxProfile();
    	myprofile.setPreference("dom.ipc.plugins.enabled", false);
    	WebDriver driver = new FirefoxDriver(myprofile);

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
	
	@Test
	public void androidTest() throws MalformedURLException{	
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\SeleniumWebDrivers\\ChromeDriver_win32_2.25\\chromedriver.exe"); 
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get("https://www.sqs.com/en-group/");
		driver.quit();
	}
	
	@Test
	public void android1Test() throws MalformedURLException{
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
        driver.get("https://www.sqs.com/en-group/");
        driver.quit();
	}

}
