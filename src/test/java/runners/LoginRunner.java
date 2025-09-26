package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/loginpage.feature",
    glue = {"stepdefinitions", "utilities"},

    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true,
    tags = "@validLogin"                     // only runs scenarios with this tag
)
public class LoginRunner {
	
}
