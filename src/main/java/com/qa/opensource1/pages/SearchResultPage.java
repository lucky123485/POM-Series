package com.qa.opensource1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart1.contrants.AppConstrants1;

public class SearchResultPage {
	private WebDriver driver;
	ElementUtil ele;

 public SearchResultPage(WebDriver driver) {
	 this.driver=driver;
	 ele=new ElementUtil(this.driver);
 }
 
 public ProductinfoPage selectProduct(String ProductName) {
	 ele.waitforVisibilityOfElement(By.linkText(ProductName), AppConstrants1.MEDIUM_DEFAULT_WAIT).click();
	 return new  ProductinfoPage(driver);
	
}

}