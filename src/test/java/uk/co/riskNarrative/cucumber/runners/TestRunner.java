package uk.co.riskNarrative.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/uk/co/riskNarrative/cucumber/features",
        glue = "uk/co/riskNarrative/cucumber/features/stepDefinitions",
        publish = true,
        monochrome = true,
        //dryRun = true,
        //tags = "@OO1TC",
        //tags = "@002TC",
        //tags = "@003TC",
        tags = "@all",
        //name = "reg",
        plugin = {
                "pretty",
                "json:target/json_output/cucumber.json",
                "junit:target/junit_xml_output/cucumber.xml",
                "html:cucumberReport/cucumber.html",
                "html:target/html_output/cucumber.html"
        })

public class TestRunner extends AbstractTestNGCucumberTests {
  /* @Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/

}
