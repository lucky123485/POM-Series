package com.qa.opensource1.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart1.contrants.AppConstrants1;

public class ProductinfoPage {

	private WebDriver driver;
	ElementUtil ele;
   
	private By productHeader=By.xpath("//div[@id='content']//h1");
	private By imgCount=By.xpath("//ul[@class='thumbnails']/li");
	private By productMetadata=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
	Map<String,String> ProductMap=new HashMap<String,String>();
	
	 
     public ProductinfoPage(WebDriver driver) {
	 this.driver=driver;
	 ele=new ElementUtil(this.driver);
 }
   public String productHeaderName() {
   String productheader=	 ele.doElementGetTextBy(productHeader);
   System.out.println("product Name: "   +productheader);
   return productheader;
 }
    public int getProductImgCount() {
    int imgcount=	   ele.waitforVisibilityOfElements(imgCount, AppConstrants1.MEDIUM_DEFAULT_WAIT).size();
     System.out.println("Product name : "    +productHeaderName()+   "Img count: "  +imgcount );
     return imgcount;

   }
    
   public void productMetaData() {
	  List <WebElement>metadatalist= ele.waitforVisibilityOfElements(productMetadata, AppConstrants1.MEDIUM_DEFAULT_WAIT);
	  
	  for(WebElement e:metadatalist) {
  String metaData=e.getText();
     String metaKey=metaData.split(":")[0].trim();
     String metaValue=metaData.split(":")[1].trim();
     ProductMap.put(metaKey, metaValue);
	
	  }
	  
	 
		  
   }
   public void productPriceData() {
	  List<WebElement> ProductPriceList= ele.waitforVisibilityOfElements(productPriceData, AppConstrants1.MEDIUM_DEFAULT_WAIT);
	    String productPrice=ProductPriceList.get(0).getText();
	    String ExTaxPrice=ProductPriceList.get(1).getText().split(":")[1].trim();
	  
	    ProductMap.put("Price",productPrice);
	    ProductMap.put("exTaxPrice", ExTaxPrice);
	    
   }
    public Map<String,String> getProductDetail() {
    	ProductMap.put("ProductName", productHeaderName());
    	productMetaData();
    	productPriceData();
    	return ProductMap;
    	
    }
     
   
   }
 
   
   
   
 
	
	

