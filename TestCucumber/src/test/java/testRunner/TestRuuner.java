package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//in eclipse we can't run scenario individually 
@RunWith(Cucumber.class)
@CucumberOptions(
		        tags= "@RegressionTest or @SmokeTest",
				features = {"/Users/sagarliki/git/Cucumber/TestCucumber/Features/Customers.feature",
						"/Users/sagarliki/git/Cucumber/TestCucumber/Features/Login.feature"},
				glue = {"stepDefination"},
				dryRun = false,   //cross check if weather every steps is having corresponding implementation or not
				monochrome = true,  //remove insecure things in  output console
                plugin = {"pretty","html:target/html/automation"}  //output in the console window
                )
public class TestRuuner extends AbstractTestNGCucumberTests{

}
