package cucumber.examples.java.codebreaker;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Jiankai Dang on 1/22/14.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class RunCodebreakerTest {
}
