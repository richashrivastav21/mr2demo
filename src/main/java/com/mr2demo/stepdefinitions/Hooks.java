package com.mr2demo.stepdefinitions;


import org.apache.log4j.Logger;

import com.mr2demo.base.Config;
import com.mr2demo.keywords.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	private static final Logger LOG = Logger.getLogger(Hooks.class);
	
	Keyword keyword = new Keyword();

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().arch64().setup();
		keyword.openBrowser(Config.getBrowsername());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());
		LOG.info("Browser setup done");
	}

	@After
	public void tearDown() {
		keyword.quitAllWindows();
		LOG.info("All windows closed");
	}

}
