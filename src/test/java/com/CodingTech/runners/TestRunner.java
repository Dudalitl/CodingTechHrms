package com.CodingTech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/",
		glue="com/CodingTechHrms/steps",
		dryRun=true,
		monochrome=true,
		strict=true,
		plugin= {
				"pretty",
				"html:target/cucumber-default-report",
				"json:target/cucumber.json", 
		"rerun:target/failed.txt" }
				
		
		
		)

public class TestRunner {

}
