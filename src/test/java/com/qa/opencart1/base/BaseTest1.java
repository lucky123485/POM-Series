package com.qa.opencart1.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart1.factory.DriverFactory1;
import com.qa.opensource1.pages.AccountPage1;
import com.qa.opensource1.pages.LoginPage1;
import com.qa.opensource1.pages.ProductinfoPage;
import com.qa.opensource1.pages.RegisterPages;
import com.qa.opensource1.pages.SearchResultPage;

public class BaseTest1 {
	
    WebDriver driver;
    DriverFactory1 df;
   protected Properties prop;
   protected   LoginPage1 lgp;
   protected   AccountPage1 acc;
   protected   SearchResultPage searchResultPage;
   protected   ProductinfoPage productinfoPage;
   protected  RegisterPages registersPage;
   
  protected SoftAssert softassert;
   
  @Parameters({"Browser"})
    @BeforeTest
     public void setup(String BrowserName) {
    	
    	df=new DriverFactory1();
        prop=  df.initprop();
        if(BrowserName!=null) {
        	System.setProperty("Browser", BrowserName);
        }
        
        driver=df.initbrowser(prop);
       lgp =new LoginPage1(driver);
    	
       softassert=new SoftAssert();
    }
    @AfterTest
    public void teardown() {
    	driver.quit();
    }

}
