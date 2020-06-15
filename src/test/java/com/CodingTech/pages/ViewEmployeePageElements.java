package com.CodingTech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CodingTech.testbase.BaseClass;

public class ViewEmployeePageElements {
	
	@FindBy (id = "empsearch_id")
	public WebElement empID;
	
	@FindBy (id = "searchBtn")
	public WebElement searchBtn;
	
	public ViewEmployeePageElements () {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
