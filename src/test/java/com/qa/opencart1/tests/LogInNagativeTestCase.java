package com.qa.opencart1.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart1.base.BaseTest1;

public class LogInNagativeTestCase extends BaseTest1 {
  
	
   @DataProvider
   public Object[][] getIncorrectLogInData() {
	   return new Object[][] {
		   
		   {"lucky@gmail.com","23455"},
		   {"test@gmail.com","234556"},
		   {"auto","12344"}
		   
		   
	   };
	   
   }
   @Test(dataProvider="getIncorrectLogInData")
   public void nagativelogInTest(String userName, String pwd) {
//   Assert.assertTrue(lgp.nagativelogInPaga(userName, pwd));
 
	   
   }
   
}
