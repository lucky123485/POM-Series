package com.qa.opencart1.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.Exception.FrameWorkException;

public class DriverFactory1 {
	
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	public  static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver initbrowser(Properties prop) {
		
		String BrowserName=prop.getProperty("browser");
		
		System.out.println("right browser:  "    +BrowserName);

		optionsManager=new OptionsManager(prop);
		
		switch (BrowserName.toLowerCase().trim()) {
		case "chrome":
	//	driver=new ChromeDriver(optionsManager.getChromeOption());
		tlDriver.set(new ChromeDriver(optionsManager.getChromeOption()));	
		
			break;
		case "edge":
		//	driver=new EdgeDriver(optionsManager.getEdgeOption());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOption()));
				break;
				
	  case "firefox":
	//	driver=new FirefoxDriver(optionsManager.getFirefoxOption());
		  tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOption()));
		break;


		default:
			System.out.println("Plese pass the right browser:"     +BrowserName);
			
			throw new FrameWorkException("Incorrect browser");
			
		}
		
		
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	public static WebDriver  getDriver() {
	return tlDriver.get();
		
		
	}
	
	public Properties initprop(){
	FileInputStream ip=null;
	prop =new Properties();
     
    String envName=	System.getProperty("env");
    System.out.println("env name is:"  +envName);
    try {
    if(envName==null) {
    	ip=new FileInputStream("./src/test/resources/config/config.qa.properties");
    }else {
    	switch (envName.toLowerCase().trim()) {
		case "qa":
			ip=new FileInputStream("/.src/test/resources/config/config.qa.properties");
			break;
			
		case "uat":
			ip=new FileInputStream("/.src/test/resources/config/config.uat.properties");
			break;
			
		case "dev":
			ip=new FileInputStream("/.src/test/resources/config/config.dev.properties");
			break;
			
		case "stage":
			ip=new FileInputStream("/.src/test/resources/config/config.stage.properties");
			break;
		case "prod":
			ip=new FileInputStream("/.src/test/resources/config/config.properties");
			break;

		default:
			System.out.println("Plese pass the right env Name:"  +envName);
			throw new FrameWorkException("Enviroment Name is incoreect:"    +envName);
			
		}
    }
    	
    }catch(FileNotFoundException e) {
	
    }	try {
		prop.load(ip);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return prop;
	
    
    
		
    }
}

