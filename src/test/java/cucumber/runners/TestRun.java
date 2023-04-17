package cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome=false,
		features = "src/test/java/cucumber/feature",
		glue = {"cucumber.stepdefinition.withjunit"}
		)

public class TestRun {

}
