package com.mr2demo.base;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mr2demo.keywords.Keyword;

public class TestBase {
	
	private static final Logger LOG = Logger.getLogger(TestBase.class);

	Keyword keyword = new Keyword();

	@BeforeMethod
	public void setUp() {
		keyword.openBrowser(Config.getBrowsername());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());
		LOG.info("Browser setup done");
	}

	@AfterMethod
	public void tearDown() {
		keyword.quitAllWindows();
		LOG.info("All windows closed");
	}

}
