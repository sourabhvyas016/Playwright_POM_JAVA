package com.my.pname.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FactoryPly {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;
	Properties prop;

	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<Playwright>();
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<Browser>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<BrowserContext>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<Page>();

	public static Playwright getTlPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getTlBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getTlBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getTlPage() {
		return tlPage.get();
	}

	public Page initBrowser(Properties prop) {
		//playwright = Playwright.create();
		tlPlaywright.set(Playwright.create());
		
		String browserName = prop.getProperty("browser");
		System.out.println("Browser Name is...." + browserName);
		Boolean headless = Boolean.valueOf(prop.getProperty("headless"));

		switch (browserName.toLowerCase()) {
		case "chromium":
			/*
			 * browser = playwright.chromium() .launch(new
			 * BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(500));
			 */
			tlBrowser.set( getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(1000)));
			break;
		case "firefox":
			//browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(500));
			tlBrowser.set(getTlPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(1000)));
			break;
		case "safari":
			//browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(500));
			tlBrowser.set(getTlPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(1000)));
			break;
		case "chrome":
			// Channel can be "chrome", "msedge", "chrome-beta", "msedge-beta" or // "msedge-dev".
		//	browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(500));
			tlBrowser.set( getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(1000)));
			break;

		case "edge":	
			tlBrowser.set( getTlPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(1000)));
			break;
			
			
		default:
			System.out.println("Please Pass The Correct Browser Name.........");
			break;
		}
		
		
		//context = browser.newContext();
		tlBrowserContext.set(getTlBrowser().newContext());
		//page = context.newPage();
		tlPage.set(getTlBrowserContext().newPage());
		System.out.println("App URL....." + prop.getProperty("url"));
		//page.navigate(prop.getProperty("url"));
		getTlPage().navigate(prop.getProperty("url"));
		return getTlPage();

	}

	public Properties init_property() throws IOException {
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
			prop = new Properties();
			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exeception ---");
		}

		return prop;

	}
	
	
	public static String catureScreenshot() {
		SimpleDateFormat customdate= new SimpleDateFormat("EEE, d MMM yyyy HH_mm_ss");
		Date date= new Date();
		String sname= customdate.format(date);
	 String path=  System.getProperty("user.dir")+"/ScreenShots/"+sname+".png";
			 
			 
			 getTlPage().screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get(path)));
			// String BasicBase64format= Base64.getEncoder().encodeToString(path.getBytes()); 
		
		return path;
	}

}
