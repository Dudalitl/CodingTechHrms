package com.CodingTech.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CodingTech.testbase.BaseClass;

public class PersonalDetailPage {
	
	@FindBy(xpath="//ul[@id='sidenav']/li[10]/a")
	public WebElement Qualifications;
	
	public PersonalDetailPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
