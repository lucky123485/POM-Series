package com.qa.opensource1.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart1.contrants.AppConstrants1;
import com.qa.opencart1.utils.ElementUtil;

public class AccountPage1 {
	
	private WebDriver driver;
	ElementUtil ele;
	
	 
	   private By search=By.xpath("//input[@type='text']");
	   private By logoutLink=By.linkText("Logout");
	   private By textlink=By.xpath("//div[@id='content']/h2");
	   private By searchproduct=By.xpath("//span[@class='input-group-btn']/button");
	
	public AccountPage1(WebDriver driver) {
		this.driver=driver;
		ele=new ElementUtil(this.driver);
	}
	
	public String accPageUrl() {
	String url=	driver.getCurrentUrl();   
	System.out.println(url);
	return url;
	}
	
	public String accPageTitle() {
	String title=	ele.WaitForTitleIs(AppConstrants1.ACCOUNT_PAGE_TITLE, AppConstrants1.SHORT_DEFAULT_WAIT);
	System.out.println(title);
	return title;
	}
	public boolean accPageLogoutLinkExist() {
		return ele.waitforVisibilityOfElement(logoutLink,AppConstrants1.SHORT_DEFAULT_WAIT).isDisplayed();
	}
	public void logout() {
		if(accPageLogoutLinkExist()) {
			ele.getclick(logoutLink);
			
		}

	}
	public boolean accPageSearchLinkExist() {
	return	ele.waitforVisibilityOfElement(search, AppConstrants1.SHORT_DEFAULT_WAIT).isDisplayed();
		
	}
	
	public List<String> accPageHeaderLinkExist() {
	List <WebElement> eleList=ele.waitforVisibilityOfElements(textlink,AppConstrants1.SHORT_DEFAULT_WAIT);
	List<String> HeaderList=new ArrayList<String>();
	for(WebElement e:eleList) {
	String text=	e.getText();
	HeaderList.add(text);
	}
	return HeaderList;
		
		
	}
	public SearchResultPage dosearch(String searchProduct) {
		ele.waitforVisibilityOfElement(search, AppConstrants1.MEDIUM_DEFAULT_WAIT).clear();
		ele.waitforVisibilityOfElement(search, AppConstrants1.MEDIUM_DEFAULT_WAIT).sendKeys(searchProduct);
		ele.getclick(searchproduct);
		return new  SearchResultPage(driver);
	}
	

}
