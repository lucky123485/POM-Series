package com.qa.opencart1.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart1.base.BaseTest1;

public class ProductResultPageTest extends BaseTest1 {
	
	
   @BeforeClass
	public void accPageSetup() {
		acc=lgp.logInPage(prop.getProperty("username"),prop.getProperty("password"));
	
	}
   
   @DataProvider
   public Object[][] getSearchResultData() {
	   return new Object[][] {
		   {"MacBook","MacBook Air",4},
		   {"Samsung", "Samsung SyncMaster 941BW",1},
			{"iMac","iMac",3}	
		   
	   };
   }
   
   @Test (dataProvider="getSearchResultData")
    public void productImgTest(String search,String ProductName,int imgCount) {
  searchResultPage=	     acc.dosearch(search);
   productinfoPage = searchResultPage.selectProduct(ProductName);
      Assert.assertEquals(productinfoPage.getProductImgCount(),imgCount);
	   
   }
   @Test
  public void productDetailTest() {
	   searchResultPage=	     acc.dosearch("MacBook");
	   productinfoPage = searchResultPage.selectProduct("MacBook Air");
Map<String ,String>	ProductInfoMap=    productinfoPage.getProductDetail();

 softassert.assertEquals(ProductInfoMap.get("Brand"),"Apple");
 softassert.assertEquals(ProductInfoMap.get("Product Code"),"Product 17");
 softassert.assertEquals(ProductInfoMap.get("Reward Points"),"700");
 softassert.assertEquals(ProductInfoMap.get("Availability"),"Out Of Stock");
 softassert.assertEquals(ProductInfoMap.get("Price"),"$1,202.00");
 softassert.assertEquals(ProductInfoMap.get("exTaxPrice"),"$1,000.00");
 softassert.assertAll();
 
 
	   
	   
   }
	}
	
	
	
	
	
	


