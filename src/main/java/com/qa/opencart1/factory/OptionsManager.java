package com.qa.opencart1.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
   
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOption(){
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
		return co;
	}
	 public FirefoxOptions getFirefoxOption() {
	    	fo=new FirefoxOptions();
	    	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
	    	if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognto");
	    	return fo;
	    }
	    public EdgeOptions getEdgeOption() {
	    	eo=new EdgeOptions();
	    	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
	    	if(Boolean.parseBoolean(prop.getProperty(prop.getProperty("incognito").trim()))) co.addArguments("--incognito");
	    	return eo;
	    }
}
