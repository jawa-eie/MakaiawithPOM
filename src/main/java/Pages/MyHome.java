package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.Given;
import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.PreAndPost;

public class MyHome extends PreAndPost {

	public MyHome(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	WebElement eleLeads;
	
	@Given("Click Leads")
	public MyLeads clickLeads() {
		click(eleLeads);
		return new MyLeads(driver, test);
	}
}
