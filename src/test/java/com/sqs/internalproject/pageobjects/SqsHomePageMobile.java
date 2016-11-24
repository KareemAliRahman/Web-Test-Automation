package com.sqs.internalproject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SqsHomePageMobile{
	
	private final WebDriver driver;

	@FindBy(xpath = "//*[@id='mobileSearch']/input[1]")
	@CacheLookup
	private WebElement searchBox;
	
	@FindBy(id = "globus")
	@CacheLookup
	private WebElement countryMenu;
	
	@FindBy(xpath = "//*[@id='openVariedContent']/ul/li/a")
	@CacheLookup
	private List<WebElement> countries;
	
	@FindBy(xpath = "//*[@id='contentStart']/div[1]/a/p")
	@CacheLookup
	private WebElement text;
	
	public SqsHomePageMobile(WebDriver driver){
		this.driver = driver;

		if (!driver.getTitle().startsWith("SQS")) {
			throw new IllegalStateException("This is not SQS.com homepage");
		}
	}
	
	public void searchFor(String keyword){
		searchBox.sendKeys(keyword);
		searchBox.submit();
	}
	
	
	public void chooseCountry(String country){
		countryMenu.click();	
		(new WebDriverWait(this.driver, 10)).until(
				ExpectedConditions.visibilityOfAllElements(countries));
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
	
	public String getTextFromSQSPage(){
		return this.text.getAttribute("innerText");
	}
}