package jarvis;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/Demo.feature", 
glue = "com.jarvis.stepdefinitions",
tags = "@MyntraDemo or @Smoke",
dryRun = false,
plugin = {
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		})
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
