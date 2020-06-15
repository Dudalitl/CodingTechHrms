package com.CodingTech.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.CodingTech.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class EmployeeLisens extends CommonMethods {

	@Then("user navigate to Qualifications")
	public void user_navigate_to_Qualifications() {
		jsClick(personDetail.Qualifications);
	} 

	@Then("user click button Add at License")
	public void user_click_button_Add_at_License() {
		click(personQual.addLicense);
	}

	@Then("user chooses License Type {string}")
	public void user_chooses_License_Type(String licensName) {
		selectDdValue(personQual.licenseType, licensName);

	}

	@Then("user add License number {string}")
	public void user_add_License_number(String licensNo) {
		sendText(personQual.licenseNo, licensNo);
	}

	@Then("user add Issued Date {string}")
	public void user_add_Issued_Date(String iData) {
		sendText(personQual.LiseIssuedDate, iData);
	}

	@Then("user add Expiry Date {string}")
	public void user_add_Expiry_Date(String eData) {
		sendText(personQual.liseExpiryDate, eData);
	}

	@Then("user click button save")
	public void user_click_button_save() {
		click(personQual.LicenSaveBtn);
		wait(5);
	}

	@Then("user check license {string} is added")
	public void user_check_license_is_added(String licensNo) {
		boolean value = false;
		List<WebElement> rows = driver.findElements(By.xpath("//form[@id='frmDelLicense']/table/tbody"));
		for (int r = 1; r < rows.size(); r++) {
			String text = rows.get(r).getText();
			if (text.contains(licensNo)) {
				value = true;
				break;
			}
			Assert.assertTrue("License is not added", value);
		}
	}

}
