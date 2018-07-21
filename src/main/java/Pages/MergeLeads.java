package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import lib.listeners.WebDriverListener;
import lib.reports.Reports;
import lib.selenium.PreAndPost;

public class MergeLeads extends PreAndPost{

	public static String leadID1, leadID2;
	
	public MergeLeads(EventFiringWebDriver driver, ExtentTest test) {
		WebDriverListener.driver=driver;
		Reports.test=test;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(xpath="(//a/img)[4]")
	WebElement eleSelSource;

	@FindBy(xpath="(//a/img)[5]")
	WebElement eleSelDest;

	@FindBy(linkText="Merge")
	WebElement eleMergeButton;
	
	@FindBy(id="ComboBox_partyIdFrom")
	WebElement eleFromLead;
	
	@FindBy(id="ComboBox_partyIdTo")
	WebElement eleToLead;
	
	@FindBy(linkText="Find Leads")
	WebElement eleFind;

	public FindLeads clickSrc() {
		click(eleSelSource);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		switchToWindow(1);
		return new FindLeads(driver, test);
	}

	public FindLeads clickDest() {
		click(eleSelDest);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		switchToWindow(1);
		return new FindLeads(driver, test);
	}

	public ViewLead clickMergeButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(eleFromLead));
		leadID1=getText(eleFromLead);
		click(eleMergeButton);
		Thread.sleep(3000);
		acceptAlert();
		Thread.sleep(2000);
		return new ViewLead(driver, test);
	}
}