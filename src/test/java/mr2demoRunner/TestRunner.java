package mr2demoRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", 
glue = "com.mr2demo.stepdefinitions",
tags = "@MyntraDemo",
dryRun = false,
plugin = {
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		})
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
