package com.CodingTech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CodingTech.testbase.BaseClass;
import com.CodingTech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{
	
	@FindBy (xpath = "//a[@id='menu_pim_viewPimModule']/b")
	public WebElement PIM;

	@FindBy (id = "menu_pim_viewEmployeeList")
	public WebElement empListPage;
	
	@FindBy (id = "menu_pim_viewEmployeeList")
	public WebElement headerEmployeeList;
	
	@FindBy (xpath = "//a[@id='menu_admin_viewAdminModule']/b")
	public WebElement headerAdmin;
	
	@FindBy(id="menu_admin_Qualifications")
	public WebElement Qualifications;
	
	@FindBy(id="menu_admin_viewLicenses")
	public WebElement Licenses;
	
	@FindBy(id="menu_admin_viewSkills")
	public WebElement Skills;
	
	@FindBy(id="menu_admin_viewEducation")
	public WebElement Education;
	
	@FindBy(id="menu_admin_viewLanguages")
	public WebElement Languages;
	
	@FindBy(id="menu_admin_membership")
	public WebElement Membership;
	

	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);		
	}
}
