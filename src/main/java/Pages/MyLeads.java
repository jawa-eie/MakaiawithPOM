package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.And;
import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.PreAndPost;;

public class MyLeads extends PreAndPost {

	public MyLeads(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Create Lead")
	WebElement eleCreate;

	@FindBy(linkText="Find Leads")
	WebElement eleFind;

	@FindBy(linkText="Merge Leads")
	WebElement eleMerge;

	@And("Click Create Lead")
	public CreateLead clickCreateLead() {
		click(eleCreate);
		return new CreateLead(driver, test);
	}

	@And("Click Find Leads")
	public FindLeads clickFindLeads() {
		click(eleFind);
		return new FindLeads(driver, test);
	}
	
	public MergeLeads clickMergeLeads() {
		click(eleMerge);
		return new MergeLeads(driver, test);
	}
}