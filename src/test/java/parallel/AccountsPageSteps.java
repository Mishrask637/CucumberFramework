package parallel;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());	
	
	private AccountsPage accountpage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	   
		List<Map<String, String>> credList =dataTable.asMaps(String.class,String.class);
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountpage = loginpage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String atitle = accountpage.getAccountPageTitle();
		System.out.println("Accounts page title "+atitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionCountList) {
		
		List<String> expectedSecList = sectionCountList.asList(String.class);
		System.out.println("Expected List "+expectedSecList);
		List<String> actualSeclist = accountpage.getAccountSectionList();
		System.out.println("Actual List "+actualSeclist);
		assertTrue(expectedSecList.containsAll(actualSeclist));
		
	}

	@Then("accounts section should be {int}")
	public void accounts_section_should_be(Integer ExpectedCount) {
		assertTrue(accountpage.getAccountSectionCount()==ExpectedCount);
	}
	
}
