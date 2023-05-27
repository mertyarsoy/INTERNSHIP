package api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "api/stepdefinitions",
        dryRun = false,
        tags = "@QA_regression-4",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
                "json:target/cucumber-reports/cucumber.json"}
)
public class Runner {
}
