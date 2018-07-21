package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.PreAndPost;

public class DuplicateLead extends PreAndPost{

	public DuplicateLead(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(id="createLeadForm_companyName")
	WebElement eleCompName;
	
	@FindBy(className="smallSubmit")
	WebElement eleCreateButton;
	
	public DuplicateLead typeCompName(String fName) {
		clear(eleCompName);
		type(eleCompName, fName);
		return this;
	}

	public ViewLead clickCreateButton() {
		click(eleCreateButton);
		return new ViewLead(driver, test);
	}				
}