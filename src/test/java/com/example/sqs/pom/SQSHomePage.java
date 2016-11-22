package com.example.sqs.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SQSHomePage {
	
	private final WebDriver driver;

	//@FindBy(xpath = "//*[@id='metaNav']/ul/li[5]")
	@FindBy(className = "country")
	@CacheLookup
	private WebElement countryMenu;

	@FindBy(linkText = "Sitemap")
	@CacheLookup
	private WebElement siteMapLink;
	
	@FindBy(xpath = "//*[@id='metaNav']/ul/li[7]/div/div[2]/ul/li/a")
	@CacheLookup
	private List<WebElement> countries;
	
	@FindBy(xpath = "//*[@id='contentStart']/div[1]/a/p")
	@CacheLookup
	private WebElement text;
	
	public SQSHomePage(WebDriver driver){
		this.driver = driver;

		if (!driver.getTitle().startsWith("SQS")) {
			throw new IllegalStateException("This is not SQS.com homepage");
		}
	}
	
	public void chooseCountry(String country){
		WebElement contryLink = null;
		for (WebElement we : countries) {
			if (we.getAttribute("innerText").equals(country)) {
				contryLink = we;
				break;
			}
		}
		Actions action = new Actions(this.driver);
		action.moveToElement(countryMenu).build().perform();
		contryLink.click();
	}
	
	public void clickSiteMap(){
		Actions action = new Actions(this.driver);
		action.moveToElement(siteMapLink).click().perform();
	}
	
	public String getTextFromSQSPage(){
		return this.text.getAttribute("innerText");
	}
	
	
	
}
