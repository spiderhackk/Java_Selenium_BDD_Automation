package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@SanityTest",features = {"src/test/resources/Dashboard.feature"},glue = {"definations"},plugin = {"pretty","html:results/testreport.html"})
public class CucumberTestNGRunnerTests extends AbstractTestNGCucumberTests {

}
