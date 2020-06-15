package com.CodingTech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CodingTech.testbase.BaseClass;

public class AddLicensesPage {
	
	@FindBy(id="btnAdd")
	public WebElement AddButton;
	
	@FindBy(id="license_name")
	public WebElement LicenseName;
	
	@FindBy(id="btnSave")
	public WebElement SaveButton;
	
	public AddLicensesPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}
