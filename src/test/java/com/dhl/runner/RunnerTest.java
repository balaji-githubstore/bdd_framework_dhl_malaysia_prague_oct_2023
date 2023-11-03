package com.dhl.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/"}
		,glue = {"com.dhl.steps","com.dhl.base"}
		,publish = false
		,plugin = {"html:target/cucumber-report.html","json:target/cucumber-report.json"}
		//,dryRun = true
		,tags = "@addemployee"
		)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
