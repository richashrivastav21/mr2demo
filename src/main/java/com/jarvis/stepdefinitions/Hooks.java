package com.jarvis.stepdefinitions;


import com.jarvis.base.Config;
import com.jarvis.keywords.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	Keyword keyword = new Keyword();

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().arch64().setup();
		keyword.openBrowser(Config.getBrowsername());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());
	}

	@After
	public void tearDown() {
		keyword.quitAllWindows();
	}

}
