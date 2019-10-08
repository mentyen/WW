package com.ww.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.utils.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div[class=\"logo__desktop-uploaded\"]")
	public WebElement logo;
	
	@FindBy(id="ela-menu-visitor-desktop-supplementa_find-a-studio")
	public WebElement findStudioButton;
	
	

}
