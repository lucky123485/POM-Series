package com.qa.opencart1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart1.base.BaseTest1;

public class RegisterPageTest extends BaseTest1 {
	
	@BeforeClass
	
	public void RegisterPageSetup() {
    registersPage=lgp.navaigateToRegistersPage();
		
	}
	public String getRandomEmailId() {
		return "TestAutomation"    + System.currentTimeMillis()  + "@opencart.com";
	}
		
	@DataProvider
	public Object [] []getUserRegData() {
		return new Object[][] {
			{"lucky","sharma","234444","3456","3456","yes"},
			{"ankit","kaushik","345667","234567","234567","no"},
			{"riya","jangra","567890","123456","123456","yes"}
			
		};
	}
	
	@Test(dataProvider="getUserRegData")
	public void userRegisterTest(String username, String lastname,String Telephone, String pwd,String confirmPwd,String subcribe) {
	boolean isRegDone=	registersPage.userRegistration(username , lastname,getRandomEmailId(),Telephone,pwd,confirmPwd,subcribe);
		Assert.assertTrue(isRegDone);
	}
	

}
