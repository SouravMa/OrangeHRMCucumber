package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"/Users/sourav.majhi/eclipse-workspace/OrangeHRM/Features/Admin.feature"},
				 glue= "stepDefinitions",
				 dryRun= false,
				 monochrome= true,
				 plugin= {"pretty", "html:/Users/sourav.majhi/eclipse-workspace/OrangeHRM/test-report/report.html"},
				 tags= "@Sanity")
public class TestRun {

}
