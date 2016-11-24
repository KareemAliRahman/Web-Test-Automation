package com.sqs.internalproject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SqsSearchPage {
	
	@FindBy(xpath = "//*[@id='content']/h1")
	@CacheLookup
	private WebElement searchHeader;
	
	@FindBy(linkText = "next >>")
	@CacheLookup
	private WebElement nextButton;
	
	@FindBy(linkText = "<< previous")
	@CacheLookup
	private WebElement previousButton;
	
	public WebElement getSearchHeader(){
		return this.searchHeader;
	}
	
	public void showNextSearchPage(){
		this.nextButton.click();
	}
	
	public void showPreviousSearchPage(){
		this.previousButton.click();
	}

}
