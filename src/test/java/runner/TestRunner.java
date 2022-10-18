package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber", tags = "@Test",
        plugin= {"pretty", "html:reports/TestRun.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
}
