package com.my.pname.pages;

import java.util.Properties;

import com.microsoft.playwright.Page;

public class LoginPage {
	public Page page;
	public Properties prop;

	// (1) Page locators or variable

	private static String usernamePlaceholder = "Enter Email";

	private static String passwordPlaceholder = "Enter Password";

	private static String loginbtnName = "Sign in";

	public static final String LOGIN_PAGE_TITLE = "Learn Automation Courses";

	// (2) Page constructor
	public LoginPage(Page page, Properties prop) {
		this.page = page;
		this.prop = prop;

	}

	// (3) Page Action Methods

	public void getUsernamePlaceholder() {
		page.getByPlaceholder(usernamePlaceholder).fill(prop.getProperty("username"));

	}

	public void getPasswordPlaceholder() {
		page.getByPlaceholder(passwordPlaceholder).fill(prop.getProperty("password"));
	}

	public void getLoginbtnName() {

		page.getByText(loginbtnName).last().click();
	}

	
	public String actualTile() {
		return page.title();
	}
}
