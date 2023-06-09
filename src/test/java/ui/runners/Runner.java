package ui.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = {"ui/hook","ui/stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@QA_Regression_2",
        dryRun = false,
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}
)
public class Runner {
}
