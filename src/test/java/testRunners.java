import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/",
        plugin={"json:target/cucumber-report.json","html:target/cucumber-html",
        "pretty","html:target/cucumber-reports.html"}
        , monochrome = true,  tags = "@NotLogin and @TableListing"
        )
public class testRunners {
}
