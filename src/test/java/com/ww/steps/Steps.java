package com.ww.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.ww.pages.FirstResultPage;
import com.ww.pages.HomePage;
import com.ww.pages.ResultPage;
import com.ww.pages.SearchPage;
import com.ww.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class Steps extends CommonMethods {

	public HomePage hpage;
	public SearchPage searchPage;
	public ResultPage resPage;
	public FirstResultPage firstResultPage;

	public String title;
	public String locationTitle;

	@Given("I am on a main page")
	public void i_am_on_a_main_page() {
		hpage = new HomePage();
		boolean logo = hpage.logo.isDisplayed();
		Assert.assertTrue(logo);

	}

	@Then("I validate expected title is {string}")
	public void i_validate_expected_title_is(String expectedTitle1) {

		Assert.assertEquals(expectedTitle1, driver.getTitle());

	}

	@Given("I click on find studio button")
	public void i_click_on_find_studio_button() {

		hpage.findStudioButton.click();

	}

	@Then("I validate title is {string}")
	public void i_validate_title_is(String expectedTitle2) {
		
			
		SoftAssert soft=new SoftAssert();
	    soft.assertEquals(expectedTitle2, driver.getTitle().trim());
		
		

		String expected = expectedTitle2.replaceAll("[^A-z,a-z]", "");
		String actual = driver.getTitle().replaceAll("[^A-z,a-z]", "");
		
		

		Assert.assertEquals(expected, actual);

	}

	@When("I enter {string} in to the search box")
	public void i_enter_in_to_the_search_box(String zip) throws InterruptedException {
		searchPage = new SearchPage();

		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(searchPage.search));
		sendText(searchPage.search, zip);
		searchPage.submit.click();

	}

	@When("I print title and distance of the first result")
	public void i_print_title_and_distance_of_the_first_result() {
		resPage = new ResultPage();

		locationTitle = resPage.titleOffirstResult.getText();

		System.out.println("--------------- Title and Distance of the first result ---------------");

		System.out.println(resPage.titleOffirstResult.getText() + " " + resPage.distanceOfFirstResult.getText());

	}

	@When("I click on a first result and verify the title")
	public void i_click_on_a_first_result_and_verify_the_title() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(resPage.firstLocationButton).click().perform();

		firstResultPage = new FirstResultPage();

		// Thread.sleep(2000);

		Assert.assertEquals(locationTitle, firstResultPage.actualTitleOfFirstResult.getText());
	}

	@Then("I print TODAY Hours and Operation from current location")
	public void i_print_TODAY_Hours_and_Operation_from_current_location() {

		String todaysDay = getWeekDay().toUpperCase();

		List<WebElement> options = firstResultPage.operatingHours;

		for (WebElement run : options) {

			String dayFromHoursOfOperation = run.getText();

			if (dayFromHoursOfOperation.contains(todaysDay)) {
				System.out.println("----------------------TODAY’s hours----------------------");
				System.out.println(dayFromHoursOfOperation);
				break;
			}

		}
	}

	
	
	@Then("I print numbers of meeting for each person")
	public void i_print_numbers_of_meeting_for_each_person(DataTable names) {

		List<String> personNames = names.asList();

		List<WebElement> weekDays = firstResultPage.studioScheduleWeekDays;

		int count, countClasses = 0;

		for (int i = 0; i < weekDays.size() - 1; i++) {

			count = i + 1;
			List<WebElement> namesAndTimeInCurrentDay = driver
					.findElements(By.xpath("//div[@class=\"schedule-detailed\"]/div[" + count + "]/div[2]/div"));

			System.out.println("--------------------" +weekDays.get(i).getText()+ "-----------------------");

			for (String person : personNames) {

				for (WebElement today : namesAndTimeInCurrentDay) {

					if (today.getText().contains(person)) {
						countClasses++;
					}
				}

				System.out.println(person + " " + countClasses);
				countClasses = 0;

			}

		}

	}

}
