package com.example.sqs.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SQSSearchPage {
	
	@FindBy(xpath = "//*[@id='content']/h1")
	@CacheLookup
	private WebElement searchHeader;
	
	public WebElement getSearchHeader(){
		return this.searchHeader;
	}
	
	
}
