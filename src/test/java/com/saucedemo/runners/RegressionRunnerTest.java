package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/saucedemo/features/"},
        glue = {"com/saucedemo/steps", "com/saucedemo/hooks"},
        tags = "@Regression",
        plugin = {"pretty", "html:target/cucumber-regression-reports", "json:target/cucumber-regression.json"},
        monochrome = true
)
public class RegressionRunnerTest {
}
