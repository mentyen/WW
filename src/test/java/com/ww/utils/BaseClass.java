package com.ww.utils;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;
	
		
	    //public static ChromeOptions options;
	    public static void setUp() {
	        ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);// "src/test/resources/configs/credentials.properties";
	        String browserName = ConfigsReader.getProperty("browser");
	        if (browserName.equalsIgnoreCase("chrome")) {
	            if (Constants.OS_NAME.contains("Mac")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
	            } else if (Constants.OS_NAME.contains("Windows")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	            } else if (Constants.OS_NAME.contains("Linux")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	                }
	            driver = new ChromeDriver();
	            //options=new ChromeOptions();
	            // options.addArguments("--headless", "--disale-gpu");
	             //driver = new ChromeDriver(options);
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            if (Constants.OS_NAME.contains("Mac")) {
	                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
	            } else if (Constants.OS_NAME.contains("Windows")) {
	                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
	            } else if (Constants.OS_NAME.contains("Linux")) {
	                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	                }
	            driver = new FirefoxDriver();
	            //options=new ChromeOptions();
	            // options.addArguments("--headless", "--disale-gpu");
	             //driver = new ChromeDriver(options);
	        } else if (browserName.equalsIgnoreCase("ie")) {
	            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer");
	            driver = new InternetExplorerDriver();
	            //options=new ChromeOptions();
	            // options.addArguments("--headless", "--disale-gpu");
	             //driver = new ChromeDriver(options);
	        } else {
	            System.out.println("browser given is wrong");
	        }
	        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().fullscreen();
	        driver.get(ConfigsReader.getProperty("url"));
	    }
	    
	    
	    public static void tearDown() {
	        driver.quit();

	//options=new ChromeOptions();
	           // options.addArguments("--headless", "--disale-gpu");
	            //driver = new ChromeDriver(options);
		
	}
	
	
	
}
