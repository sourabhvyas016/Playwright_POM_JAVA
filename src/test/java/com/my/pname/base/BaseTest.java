package com.my.pname.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.my.pname.factory.FactoryPly;
import com.my.pname.pages.SignUpPage;
import com.my.pname.pages.LoginPage;

public class BaseTest {

	FactoryPly playwrightfactory;
	Page page;
	protected Properties prop;
	public SignUpPage signuppage;
	public LoginPage loginPage;

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String BrowserName) throws Throwable {
		playwrightfactory = new FactoryPly();
		prop = playwrightfactory.init_property();
		
		if(BrowserName !=null)
		{
			prop.setProperty("browser", BrowserName);
		}
		page = playwrightfactory.initBrowser(prop);
		signuppage = new SignUpPage(page);
		loginPage = new LoginPage(page, prop);
	}

	@AfterTest
	public void teardown() {
		page.context().browser().close();

	}

}
