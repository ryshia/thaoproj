package cucumber.runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(tags="@InvalidCredentials", features="src/test/resources/feature/loginTestNG.feature", glue="cucumber.stepdefinition.withtestng")
public class TestNG_Test extends AbstractTestNGCucumberTests {

}
