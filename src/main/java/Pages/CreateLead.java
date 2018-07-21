package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.WebDriverServiceImpl;

public class CreateLead extends WebDriverServiceImpl{

	public CreateLead(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompName;

	@FindBy(id="createLeadForm_firstName")
	WebElement eleFirstName;

	@FindBy(id="createLeadForm_lastName")
	WebElement eleLastName;

	@FindBy(id="createLeadForm_primaryPhoneNumber")
	WebElement elePhone;

	@FindBy(className="smallSubmit")
	WebElement eleCreate;
	
	@FindBy(className="errorMessage")
	WebElement eleErrorMsg;

	@And("Enter Company Name as (.*)")
	public CreateLead typeCompName(String cName) {
		type(eleCompName, cName);
		return this;
	}

	@And("First Name as (.*)")
	public CreateLead typeFirstName(String fName) {
		type(eleFirstName, fName);
		return this;
	}

	@And("Last Name as (.*)")
	public CreateLead typeLastName(String lName) {
		type(eleLastName, lName);
		return this;
	}

	@And("Enter Phone No as (.*)")
	public CreateLead typePhone(String phoneNum) {
		type(elePhone, phoneNum);
		return this;
	}

	@When("Click Create Pass")
	public ViewLead clickCreate() {
		click(eleCreate);
		return new ViewLead(driver, test);			
	}	
	
	@When("Click Create Fail")
	public void clickCreate1() {
		click(eleCreate);		
	}
	
	@Then("Creation Failed")
	public void leadCreateError() {
		System.out.println(eleErrorMsg.getText());
	}
}