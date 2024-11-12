package com.my.pname.tests;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.my.pname.base.BaseTest;

import constants.AppConstant;

public class SignUpTest extends BaseTest {

	
	
	
	
	
	@Test(priority = 1)
	public void signupPageTitleTest()
	{
		assertEquals(signuppage.actualTile(), AppConstant.LOGIN_TITLE_TEXT);
		
	}
	
	
	
	
	@Test(priority = 2)
	public void signupOp()
	{
		
		//PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		assertThat(signuppage.getSignupBtntext()).isEnabled();
		signuppage.getSignupBtntext().click();
		
		assertThat(signuppage.getSignUpPageBtntext()).isDisabled();
		signuppage.getFullNamePlaceholder().fill(new Faker().name().fullName());
		
		signuppage.getEmailPlaceholder().fill(new Faker().name().firstName()+"_"+new Faker().name().lastName()+"@gmail.com");
		
		signuppage.getPasswordPlaceholder().fill("dsTest123");
		
		signuppage.getLanguagesCheckbBox().click();
		assertThat(signuppage.getLanguagesCheckbBox()).isChecked();
		signuppage.getGenderRadioBtn().click();
		assertThat(signuppage.getGenderRadioBtn()).isChecked();
		signuppage.getStateDropDown().selectOption("Goa");
		
		signuppage.getHobbiesDropDown().selectOption(signuppage.getHobbiesList());
		assertThat(signuppage.getSignUpPageBtntext()).isEnabled();
		signuppage.getSignUpPageBtntext().click();
	}
	
	@Test(priority = 3)
	public void scussSignUpMsgTest()
	{
		assertThat(signuppage.getVerifyScussSignUptext()).isVisible();

		
	}
	
	

	
	
	
	
}
