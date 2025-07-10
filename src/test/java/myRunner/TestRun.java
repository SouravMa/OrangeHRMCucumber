package myRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"/Users/sourav.majhi/eclipse-workspace/OrangeHRM/Features/Recruitment.feature"},
				 glue= "stepDefinitions",
				 dryRun= false,
				 monochrome= true,
				 plugin= {"pretty", "html:/Users/sourav.majhi/eclipse-workspace/OrangeHRM/test-report/report.html"},
				 tags= "")
public class TestRun {

}
