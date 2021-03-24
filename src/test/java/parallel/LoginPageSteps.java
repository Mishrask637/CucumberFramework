package parallel;

import static org.junit.Assert.assertTrue;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.threadlocalDriver.get().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getLoginPagetitle();
		System.out.println("The page title is "+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String pageTitle) {
		assertTrue(title.equals(pageTitle));	
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	  assertTrue(loginpage.isForgotPassLinkExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginpage.enteruserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String passWord) {
		loginpage.enterpasswd(passWord);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickOnLogin();
	}

	/*
	 * @Then("user gets the title of the accounts page") public void
	 * user_gets_the_title_of_the_accounts_page() { loginpage.getLoginPagetitle(); }
	 */
	
}
