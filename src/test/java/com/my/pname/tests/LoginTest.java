package com.my.pname.tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.my.pname.base.BaseTest;
import com.my.pname.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void loinOp()
	{
		
		assertEquals(loginPage.actualTile(), LoginPage.LOGIN_PAGE_TITLE);
		loginPage.getUsernamePlaceholder();
		loginPage.getPasswordPlaceholder();
		loginPage.getLoginbtnName();
		
		
	}
	
}
