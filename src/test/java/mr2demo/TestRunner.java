package mr2demo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/Demo.feature", 
glue = "com.mr2demo.stepdefinitions",
tags = "@MyntraDemo1",
dryRun = false,
plugin = {
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		})
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
