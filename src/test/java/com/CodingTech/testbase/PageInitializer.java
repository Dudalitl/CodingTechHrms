package com.CodingTech.testbase;

import com.CodingTech.pages.AddLicensesPage;
import com.CodingTech.pages.DashboardPageElements;
import com.CodingTech.pages.LoginPageElements;
import com.CodingTech.pages.ViewEmployeePageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	public static ViewEmployeePageElements viewEmp;
	public static AddLicensesPage addLicense;
	

	public static void initialize() {

		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		viewEmp = new ViewEmployeePageElements();
		addLicense = new AddLicensesPage();
	}
}
