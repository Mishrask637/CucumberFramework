package parallel;

//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
			features= {"src\\rest\\resources\\parallel"},
			glue={"parallel"},
			plugin= {"pretty",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"timeline:test-output-thread/",
					 "rerun:target\\failedcases.txt"
			},
			publish=true,
			monochrome = true
		)

public class ParallelRun extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
		
	}
	
}
