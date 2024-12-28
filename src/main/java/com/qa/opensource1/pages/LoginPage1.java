package com.qa.opensource1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart1.contrants.AppConstrants1;
import com.qa.opencart1.utils.ElementUtil;

public class LoginPage1 {

	private WebDriver driver;
	 ElementUtil ele;
	
	private By username=By.id("input-email");
	private By pwd=By.id("input-password");
	private By logInBtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	private By logo=By.cssSelector(".img-responsive");
	private By forgottenPwd=By.linkText("Forgotten Password");
	private By registerpage=By.linkText("Register");
//	private By warningMesg=By.xpath("//*[@id=\"account-login\"]/div[1]/text()");
	
	public LoginPage1(WebDriver driver) {
		this.driver=driver;
		ele=new  ElementUtil(this.driver);					
	}
	
	public String getLogInPageTitle() {
		  String title=ele.WaitForTitleIs(AppConstrants1.LOGIN_PAGE_TITLE, AppConstrants1.SHORT_DEFAULT_WAIT);
		  System.out.println("Log in page Title is: "   +title);
		  return title;
	}
	
	public String  getLogInPageUrl() {
	String url=	driver.getCurrentUrl();
	  System.out.println("Log in Page url is :"    +url);
	  return url;
		
	}
	
	public boolean isLogInPageLogoVisible() {
		return ele.waitforVisibilityOfElement(logo,AppConstrants1.SHORT_DEFAULT_WAIT).isDisplayed();
	}
	
	public boolean isLogInPageForgotPwdLinkIsExist() {
		return ele.waitforVisibilityOfElement(forgottenPwd, AppConstrants1.SHORT_DEFAULT_WAIT).isDisplayed();
	}
	
	public AccountPage1 logInPage(String userName,String Password) {
		ele.waitforVisibilityOfElement(username,AppConstrants1.SHORT_DEFAULT_WAIT).sendKeys(userName);
		ele.dosendKeys(pwd, Password);
		ele.getclick(logInBtn);
	//	System.out.println("User is logged in");
		return new AccountPage1(driver);
		
	}
	
//	 public boolean nagativelogInPaga(String Username,String password ) {
//		 ele.waitforVisibilityOfElement(username, 5).clear();
//		 ele.waitforVisibilityOfElement(username, AppConstrants1.MEDIUM_DEFAULT_WAIT);
//		 ele.dosendKeys(username, Username);
//		 ele.dosendKeys(pwd, password);
//		 ele.getclick(logInBtn);
//		 
//    String errormessage	= ele.waitforVisibilityOfElement(warningMesg, AppConstrants1.MEDIUM_DEFAULT_WAIT).getText();
//     System.out.println(errormessage);
//     if(errormessage.contains(AppConstrants1.ERROR_WARNING_MESSAGE)) {
//    	 return true;
//     }
//          return false;
//	 }
//	
	public RegisterPages navaigateToRegistersPage() {
		ele.getclick(registerpage);
		return new RegisterPages(driver);
	}
	
	
	
}
