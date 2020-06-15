package com.CodingTech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CodingTech.testbase.BaseClass;
import com.CodingTech.utils.CommonMethods;

public class LoginPageElements extends CommonMethods {

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;

	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
