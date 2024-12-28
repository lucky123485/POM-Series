package com.qa.opensource1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart1.contrants.AppConstrants1;

public class RegisterPages {
	
	private WebDriver driver;
	 ElementUtil ele;
	
	private By Username=By.id("input-firstname");
	private By Lastname=By.id("input-lastname");
	private By Email=By.id("input-email");
	private By Telephone=By.id("input-telephone");
	private By Pwd=By.id("input-password");
	private By ConfirmPwd=By.id("input-confirm");
	
	private By SubcribeYes=By.xpath("(//label[@class='radio-inline']/input[@type='radio'])[1]");
	private By SubcribeNo=By.xpath("(//label[@class='radio-inline']/input[@type='radio'])[2]");
	
	private By PrivacyPolicyCheckBox=By.name("agree");
	private By Continue=By.xpath("//input[@value='Continue']");
	
	private By SucessMesg=By.xpath("//div[@id='content']/h1");
	
	private By logoutLink=By.linkText("Logout");
	private By RegisterLink=By.linkText("Register");
	
	public  RegisterPages(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(this.driver);
	}
	public boolean userRegistration(String userName,String lastName,String email,String telePhone,String pwd,String confirmPwd,String subcribe) {
		ele.waitforVisibilityOfElement(Username,AppConstrants1.MEDIUM_DEFAULT_WAIT).sendKeys(userName);
		ele.dosendKeys(Lastname, lastName);
		ele.dosendKeys(Email, email);
		ele.dosendKeys(Telephone, telePhone);
		ele.dosendKeys(Pwd, pwd);
		ele.dosendKeys(ConfirmPwd,confirmPwd);
		
		if(subcribe.equalsIgnoreCase("yes")) {
			ele.getclick(SubcribeYes);
		}else {
			ele.getclick(SubcribeNo);
		}
		ele.getclick(PrivacyPolicyCheckBox);
		ele.getclick(Continue);
		 
		String sucessmesg=ele.waitforVisibilityOfElement(SucessMesg, AppConstrants1.MEDIUM_DEFAULT_WAIT).getText();
		System.out.println(sucessmesg);
		if(sucessmesg.contains(AppConstrants1.USER_REGISTRATION_SUCESS_MESSAGE)) {
			ele.getclick(logoutLink);
			ele.getclick(RegisterLink);
			return true;
		}else {
			return false;
		}
		
	}
	

}
