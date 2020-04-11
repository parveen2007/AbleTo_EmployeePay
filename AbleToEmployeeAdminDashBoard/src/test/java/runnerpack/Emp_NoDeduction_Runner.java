package runnerpack;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features="src/test/resources/Features",
        glue="stepdefinition",
        tags= {"@BiweeklySalary, @NoDeduction"} ,
        plugin= {"pretty","html:testReport"},
        monochrome=true
)

public class Emp_NoDeduction_Runner extends AbstractTestNGCucumberTests{

}

