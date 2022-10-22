package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="C://Users//DELL//eclipse-workspace//BDDFramework//Features//OrangeHRM.feature",
		glue="stepDefinations"
		
		)

public class TestRunner {

}
