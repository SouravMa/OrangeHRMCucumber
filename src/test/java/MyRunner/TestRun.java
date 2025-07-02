package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "/Users/sourav.majhi/eclipse-workspace/NopCommerceCucumber/Features/Login-Logout.feature",
				 glue= "stepDefinitions",
				 dryRun= false,
				 monochrome= true,
				 plugin= {"pretty", "html:/Users/sourav.majhi/eclipse-workspace/NopCommerceCucumber/test-report/report.html"})
public class TestRun {

}
