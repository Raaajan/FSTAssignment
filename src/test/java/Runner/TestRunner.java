package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = "D:\\Automation\\Eclipse\\FST\\src\\test\\java\\FeatureFiles\\Api.feature",
		glue = "Stepdefination",
		monochrome = true,
		publish=true,
		plugin= {"pretty","html:target/cucumber/saucedemo.html"},
		dryRun = false
		//tags = "@scenario3"
		)

public class TestRunner {

}
