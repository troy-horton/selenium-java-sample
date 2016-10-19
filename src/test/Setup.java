package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Setup {
	
    public WebDriver driver;
    
    //initialize driver for browser
    public void DefineBrowser(String browser)
    {
        switch (browser)
        {        
            case "firefox":
            {
                driver = new FirefoxDriver();
                break;
            }
            case "chrome":
            {  
            	String chromepath = "/Users/troyhorton/Documents/workspace/SeleniumTest/chromedriver";
            	System.setProperty("webdriver.chrome.driver", chromepath);
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("allow-running-insecure-content");
                options.addArguments("ignore-certificate-errors");
                capabilities.setCapability("chrome.binary",chromepath);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
                break;
            }
            default:
            {
                driver = new FirefoxDriver();
                break;
            }                
        }

    }
}
