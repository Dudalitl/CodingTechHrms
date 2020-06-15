package com.CodingTech.steps;

import com.CodingTech.utils.CommonMethods;
import com.CodingTech.utils.ConfigsReader;

import io.cucumber.java.en.Given;

public class LoginSteps extends CommonMethods {

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
		//enter username and password to login pahe
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		//navigate to employee list page
		jsClick(dashboard.PIM);
		jsClick(dashboard.empListPage);

	}

}
