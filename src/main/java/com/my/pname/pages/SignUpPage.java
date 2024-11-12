package com.my.pname.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignUpPage {
 Page page;
 
 
 // (1) Page locators or variable 
 
	private String VerifyTitletext = "Learn Automation Courses";
	private String SignupBtntext = "New user? Signup";
	private String SignUpPageBtntext = "Sign up";
	private String FullNamePlaceholder = "Name";
	private String EmailPlaceholder = "Email";
	private String PasswordPlaceholder = "Password";
	private String LanguagesCheckbBox = "xpath=//label[text()='java']//preceding::input[1]";
	private String GenderRadioBtn = "xpath=//label[text()='Female']//preceding::input[1]";
	private String StateDropDown = "#state";
	private String HobbiesList[]= {"Playing","Reading","Singing"};

	private String HobbiesDropDown = "#hobbies";
	private String VerifyScussSignUptext = "Signup successfully, Please login!";
	
	
	 // (2) Page constructor 

	public SignUpPage(Page page) {
		this.page=page;
		
	}
	
	
	
	 // (3) Page Action Methods 

	
	
	public String actualTile()
	{
		return page.title();
	}
	
	public String getVerifyTitletext() {
		return VerifyTitletext;
	}
	public Locator getSignupBtntext() {
		
		return page.getByText(SignupBtntext);
	}
	public Locator getSignUpPageBtntext() {
		return page.getByText(SignUpPageBtntext).nth(1) ;
	}
	public Locator getFullNamePlaceholder() {
		return page.getByPlaceholder(FullNamePlaceholder) ;
	}
	public Locator getEmailPlaceholder() {
		return page.getByPlaceholder(EmailPlaceholder) ;
	}
	public Locator getPasswordPlaceholder() {
		return page.getByPlaceholder(PasswordPlaceholder) ;
	}
	public Locator getLanguagesCheckbBox() {
		return page.locator(LanguagesCheckbBox);
	}
	public Locator getGenderRadioBtn() {
		return page.locator(GenderRadioBtn);
	}
	public Locator getStateDropDown() {
		return page.locator(StateDropDown);
	}
	public String[] getHobbiesList() {
		return HobbiesList;
	}
	
	public Locator getHobbiesDropDown() {
		return page.locator(HobbiesDropDown);
	}
	public Locator getVerifyScussSignUptext() {
		return page.getByText(VerifyScussSignUptext);
	}


	
	
	
}
