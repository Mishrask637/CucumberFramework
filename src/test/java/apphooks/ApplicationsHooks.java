package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationsHooks {

	private DriverFactory drivergactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	
	@Before(order = 0)
	public void getprop()
	{
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}
	
	@Before(order = 1)
	public void launchBrowser()
	{
		String browserName = prop.getProperty("browser");
		drivergactory = new DriverFactory();
		driver = drivergactory.init_driver(browserName);
	}
	
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order = 1)
	public void teardown(Scenario sc)
	{
		if(sc.isFailed())
		{
			String screenshotName = sc.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcepath, "image/png", screenshotName);
		}
	}
}
