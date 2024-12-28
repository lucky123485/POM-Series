package com.qa.opencart1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart1.base.BaseTest1;
import com.qa.opencart1.contrants.AppConstrants1;

public class logInPageTest1 extends BaseTest1{


	
@Test(priority=1)
public void logInPageTitleTest() {
String title=	lgp.getLogInPageTitle();
  Assert.assertEquals(title,AppConstrants1.LOGIN_PAGE_TITLE );
  
}
@Test(priority=2)
public void logInPageUrlTest() {
String url=	lgp.getLogInPageUrl();
 Assert.assertTrue(url.contains(AppConstrants1.LOGIN_PAGE_URL_FRACTION));
 
 }
@Test(priority=3)
  public void logInPageLogoVisisbleTest() {
	  Assert.assertTrue(lgp.isLogInPageLogoVisible());
  }
@Test(priority=4)
  public void logInPageForwardLinkExistTest() {
	  Assert.assertTrue(lgp.isLogInPageForgotPwdLinkIsExist());
  }
@Test(priority=5)
  public void logInPageTest() {
	acc=lgp.logInPage(prop.getProperty("username"),prop.getProperty("password"));
	Assert.assertTrue(acc.accPageLogoutLinkExist());
	
	
	//Assert.assertTrue(lgp.logInPage("lucky@gamil.com","9034272952"));
  }

	
	

}
