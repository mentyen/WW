package com.ww.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.utils.BaseClass;

public class ResultPage extends BaseClass{
	
	public ResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[contains(text(),'WW Studio Flatiron')]")
	public WebElement titleOffirstResult;
	
	@FindBy(xpath="//div[contains(text(),'0.49 mi.')]")
	public WebElement distanceOfFirstResult;
	
	@FindBy(xpath="//div[@id=\"ml-1180510\"]/result-location/div")
	public WebElement firstLocationButton;

}
