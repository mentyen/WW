package com.ww.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.utils.BaseClass;

public class FirstResultPage extends BaseClass{

	public FirstResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="span[ng-if=\"!linkName\"]")
	public WebElement actualTitleOfFirstResult;
	
	
	@FindBy(xpath="//ul[@class=\"hours-list list-unstyled hours-list--count-7\"]/li/div")
	public List<WebElement> operatingHours;
	
	
	@FindBy(xpath="//div[@class=\"schedule-detailed\"]/div/div[1]")
	public List<WebElement> studioScheduleWeekDays;
	
}
