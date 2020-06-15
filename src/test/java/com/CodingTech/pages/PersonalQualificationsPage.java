package com.CodingTech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CodingTech.testbase.BaseClass;

public class PersonalQualificationsPage {

	@FindBy(id = "addWorkExperience")
	public WebElement addWork;

	@FindBy(id = "addEducation")
	public WebElement addEducation;

	@FindBy(id = "addSkill")
	public WebElement addSkill;

	@FindBy(id = "addLanguage")
	public WebElement addLanguage;

	@FindBy(id = "addLicense")
	public WebElement addLicense;
	
	@FindBy(id = "license_code")
	public WebElement licenseType;
	
	@FindBy(id = "license_license_no")
	public WebElement licenseNo;
	
	@FindBy(id = "license_date")
	public WebElement LiseIssuedDate;
	
	@FindBy(id = "license_renewal_date")
	public WebElement liseExpiryDate;
	
	@FindBy(id = "btnLicenseSave")
	public WebElement LicenSaveBtn;
	

	public PersonalQualificationsPage() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}

}
