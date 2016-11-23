package commonUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTestUtils {

	private static HashMap<String, Object> IPHONE7_DEVICE_METRICS=new HashMap<String,Object>(){{put("width",375);put("height",667);put("pixelRatio",2.0);}};

	private static HashMap<String, Object> SGS3_DEVICE_METRICS=new HashMap<String,Object>(){{put("width",360);put("height",640);put("pixelRatio",2.0);}};

	private static HashMap<String, Object> IPHONE6SPLUS_DEVICE_METRICS=new HashMap<String,Object>(){{put("width",414);put("height",736);put("pixelRatio",3.0);}};

	private static HashMap<String, Object> LGG5_DEVICE_METRICS=new HashMap<String,Object>(){{put("width",360);put("height",640);put("pixelRatio",4.0);}};

	private static DesiredCapabilities getCapabilitiesHelper(HashMap<String, Object> deviceMetrics) {
		Map<String, Object> mobileEmulation = new HashMap<String, Object>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return DesiredCapabilities.chrome();
	}

	public static DesiredCapabilities getCapabilitiess(String driver) {
		switch (driver) {
		case "chrome":
			return DesiredCapabilities.chrome();
		case "firefox":
			return DesiredCapabilities.firefox();
		case "ie":
			return DesiredCapabilities.internetExplorer();
		case "iphone7":
			return getCapabilitiesHelper(IPHONE7_DEVICE_METRICS);
		case "samsung galaxy s3":
			return getCapabilitiesHelper(SGS3_DEVICE_METRICS);
		case "iphone6splus":
			return getCapabilitiesHelper(IPHONE6SPLUS_DEVICE_METRICS);
		case "LGG5":
			return getCapabilitiesHelper(LGG5_DEVICE_METRICS);
		case "Android":
			return null;
		default:
			return DesiredCapabilities.chrome();
		}
	}

	private static WebDriver getDriverLocal(String driver) {
		switch (driver) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "ie":
			return new InternetExplorerDriver();
		case "Android":
			return null;
		default:
			return new ChromeDriver(getCapabilitiess(driver));
		}
	}
	
	private static WebDriver getDriverRemote(String driver){
	   	String SeleniumGridHost = PropertyHandler.getInstance().getValue("selenium-gird-host");
	   	String SeleniumGridPort = PropertyHandler.getInstance().getValue("selenium-gird-port");
		WebDriver webDriver = null;
		DesiredCapabilities cap = getCapabilitiess(driver);
		try {
			webDriver = new RemoteWebDriver(new URL("http://"+ SeleniumGridHost + ":" + SeleniumGridPort +"/wd/hub"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return webDriver;
	}

	public static WebDriver getDriver(String driver){
		String env = PropertyHandler.getInstance().getValue("env");
		
		if(env.equals("dev")){
			return getDriverLocal(driver);
		}else{
			return getDriverRemote(driver);
		}
	}
}