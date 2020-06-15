package com.CodingTech.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.CodingTech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSkillsSteps extends CommonMethods {

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String empId) {
		//enter user id in Employee List page
		sendText(viewEmp.empID, empId);
	}

	@When("click on search button")
	public void click_on_search_button() {
		jsClick(viewEmp.searchBtn);
		wait(5);
	}
	
	@Then("user see employee info of {string} is displayed")
	public void user_see_employee_information_is_displayed(String empId) {
		
		//locate result table and list rows
		List<WebElement> rows =driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
		
		//check every row to include employee ID data or not. If any row included expected data, break loop and go forward
		boolean value = false;
		for(int r=1; r<rows.size(); r++) {
			String rowText = rows.get(r).getText();
			if(rowText.contains(empId)) {
				value = true;
				break;
			}
			Assert.assertTrue("Employee info is not displayed on the table",value);
			wait(2);
		}
	
	}

	@When("user can click employee id on the table and display details")
	public void user_can_click_employee_information_on_the_table_and_display_details() {

		//click employee ID link on the table. We used employee ID to search employee info, 
		//so there will be appeared only one row (first row) on the table and employee ID number is located in first row and click it
		driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]/a")).click();
		wait(2);

	}
}
