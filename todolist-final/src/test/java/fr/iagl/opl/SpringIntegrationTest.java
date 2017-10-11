package fr.iagl.opl;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:cucumber/", glue = "fr/iagl/opl/steps")
public class SpringIntegrationTest {

}
