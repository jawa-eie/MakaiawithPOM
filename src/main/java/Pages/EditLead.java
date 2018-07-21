package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.PreAndPost;

public class EditLead extends PreAndPost{

	public EditLead(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(id="updateLeadForm_firstName")
	WebElement eleFirstName;
	
	@FindBy(className="smallSubmit")
	WebElement eleUpdate;
	
	@FindBy(id="updateLeadForm_industryEnumId")
	WebElement eleIndustry;
	
	@FindBy(id="updateLeadForm_currencyUomId")
	WebElement eleCurrency;
	
	public EditLead typeFirstName(String fName) {
		clear(eleFirstName);
		type(eleFirstName, fName);
		return this;
	}
	
	@And("Add Industry as (.*)")
	public void selectIndustry(String industry) {
		selectDropDownUsingVisibleText(eleIndustry, industry);
	}
	
	@And("Add Currency as (.*)")
	public void selectCurrency(String currency) {
		selectDropDownUsingVisibleText(eleCurrency, currency);
	}

	@When("Click Update")
	public ViewLead clickUpdateButton() {
		click(eleUpdate);
		return new ViewLead(driver, test);
	}				
}