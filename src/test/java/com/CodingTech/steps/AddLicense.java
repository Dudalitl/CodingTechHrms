package com.CodingTech.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.CodingTech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddLicense extends CommonMethods {

	@When("user navigate to Licenses")
	public void user_navigate_to_Licenses() {
		jsClick(dashboard.headerAdmin);
		jsClick(dashboard.Qualifications);
		jsClick(dashboard.Licenses);
	}

	@When("user click button add")
	public void user_click_button_add() {
		click(addLicense.AddButton);
	}

	@When("user add Licenses {string}")
	public void user_add_Licenses_name(String licenseName) {
		sendText(addLicense.LicenseName, licenseName);
	}

	@When("user click save button")
	public void user_click_save_button() {
		click(addLicense.SaveButton);
		
	}

	@Then("user check license {string} is displayed")
	public void user_check_license_is_displayed(String licenseName) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='recordsListTable']/tbody"));
		boolean value = false;
		for (int r = 1; r < rows.size(); r++) {
			String rowText = rows.get(r).getText();
			if (rowText.contains(licenseName)) {
				value = true;
				break;
			}
			Assert.assertTrue("License not added", value);
		}
	}
}
