package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com/saucedemo/features/"},
        glue = {"com/saucedemo/steps", "com/saucedemo/hooks"},
        tags = "@Sanity",
        plugin = {"pretty", "html:target/cucumber-sanity-reports", "json:target/cucumber-sanity.json"},
        monochrome = true
)
public class SanityRunnerTest {
}
