package com.CodingTech.testbase;

import com.CodingTech.pages.LoginPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	
	
	public static void initialize() {
		
		login=new LoginPageElements();
		
	}
}
