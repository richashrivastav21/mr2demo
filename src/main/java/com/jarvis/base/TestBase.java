package com.jarvis.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jarvis.keywords.Keyword;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	Keyword keyword = new Keyword();

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().arch64().setup();
		keyword.openBrowser(Config.getBrowsername());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());
	}

	@AfterMethod
	public void tearDown() {
		keyword.quitAllWindows();
	}

}
