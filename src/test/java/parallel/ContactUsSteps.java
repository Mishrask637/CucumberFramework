package parallel;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

	private ContactUsPage contact = new ContactUsPage(DriverFactory.getDriver());
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheet name {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheet_name_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	    ExcelReader reader = new ExcelReader();
	    List<Map<String,String>> testData =  reader.getData("C:\\Users\\LENOVO\\Desktop\\Automation.xlsx", sheetName);
	    String heading=testData.get(rowNumber).get("SubjectHeading");
	    String email=testData.get(rowNumber).get("Email");
	    String colref=testData.get(rowNumber).get("Orderref");
	    String msg=testData.get(rowNumber).get("Message");
	    contact.fillContactUsForm(heading, email, colref, msg);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contact.clickSend();
	}

	@Then("it shows successful message {string}")
	public void it_shows_successful_message(String successMsg) {
		System.out.println("Expected Success Msg "+successMsg);
		System.out.println("Actual Success Msg "+contact.getSuccessMessg());
		assertTrue(contact.getSuccessMessg().equals(successMsg));
		
	}
	
}
