 package com.qa.opencart1.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart1.base.BaseTest1;
import com.qa.opencart1.contrants.AppConstrants1;

public class AccountPageTest1 extends BaseTest1 {

	@BeforeClass
	
	public void accPageSetup() {
		acc=lgp.logInPage(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	@Test
	public void accPageUrlTest() {
	String url=	acc.accPageUrl();
	Assert.assertEquals(url,AppConstrants1.ACCOUNT_PAGE_URL);
	}
	@Test
	public void accPageTitleTest() {
	String title=	acc.accPageTitle();
	Assert.assertTrue(title.contains(AppConstrants1.ACCOUNT_PAGE_TITLE));
	}
	@Test
	public void accPageSearchLinkExistTest() {
    Assert.assertTrue(acc.accPageSearchLinkExist());
	
	}
	@Test
	public void accPageLogoutLinkExist() {
		Assert.assertTrue(acc.accPageLogoutLinkExist());
	}
	@Test
	public void accPageHeaderLinkExist() {
	List<String> headerlink=  acc.accPageHeaderLinkExist();
	System.out.println(headerlink.size());
	Assert.assertEquals(headerlink, AppConstrants1.ACCOUNT_PAGE_HEADER_LIST);
//	System.out.println(headerlink);
	}
	@Test
	public void searchTest() {
		searchResultPage =acc.dosearch("MacBook");
        productinfoPage=searchResultPage.selectProduct("MacBook Air");
    String headername=    productinfoPage.productHeaderName();
     Assert.assertEquals(headername,"MacBook Air");
	}
	
	
	
}
