package com.ww.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.utils.BaseClass;

public class SearchPage extends BaseClass{
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="meetingSearch")
	public WebElement search;
	
	@FindBy(css="button[class=\"btn spice-translated\"]")
	public WebElement submit;

}
