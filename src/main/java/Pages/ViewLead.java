package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.PreAndPost;

public class ViewLead extends PreAndPost {

	public static String leadIDRead;
	
	public ViewLead(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="viewLead_firstName_sp")
	WebElement eleFirstName;
	
	@FindBy(id="viewLead_companyName_sp")
	WebElement eleCompName;
	
	@FindBy(linkText="Edit")
	WebElement eleEditButton;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFind;

	@FindBy(linkText="Duplicate Lead")
	WebElement eleDuplicate;
	
	@FindBy(linkText="Delete")
	WebElement eleDelete;
	
	@FindBy(xpath="(//table)[20]//tr[8]/td[2]")
	WebElement eleIndustry;
	
	public FindLeads clickFindLeads() {
		click(eleFind);
		return new FindLeads(driver, test);
	}
	
	public void verifyFirstName(String fName) {
		verifyExactAttribute(eleFirstName, "value", fName);
	}
	
	public void verifyCompName(String cName) {
		verifyPartialAttribute(eleCompName, "value", cName);
	}
	
	@And("Click Edit")
	public EditLead clickEditLead() {
		click(eleEditButton);
		return new EditLead(driver, test);
	}
	
	public DuplicateLead clickDuplicate() {
		click(eleDuplicate);
		return new DuplicateLead(driver, test);
	}
	
	public ViewLead clickDelete() {
		click(eleDelete);
		return this;
	}
	
	@Then("Lead Created")
	public ViewLead getLeadID() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(locateElement("xpath", "//span[@id='viewLead_companyName_sp']")));
		leadIDRead = getText(locateElement("xpath", "//span[@id='viewLead_companyName_sp']"))
				.substring(getText(locateElement("xpath", "//span[@id='viewLead_companyName_sp']")).lastIndexOf('(')+1, 
						getText(locateElement("xpath", "//span[@id='viewLead_companyName_sp']")).lastIndexOf(')'));
		return this;
	}
	@Then("Verify Lead")
	public void verifyLead() {
		verifyExactText(eleIndustry, "Computer Software");		
	}
}