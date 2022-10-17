package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber", tags = "@test",
        plugin= {"pretty", "html:reports/TestRun.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}
