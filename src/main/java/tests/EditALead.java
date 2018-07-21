package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHome;
import lib.selenium.PreAndPost;

public class EditALead extends PreAndPost {
	
	@BeforeTest
	public void setVal() {
		testCaseName="EditLead";
		testDescription="Search and Edit a Lead";
		excelName="EditALead";
		nodeName="Leads";
		author="Jawa";
		category="Smoke";
	}
	
	@Test(dataProvider="TST")
	public void editLead(String fName,String fName1){
		
		new MyHome(driver, test)
		.clickLeads()
		.clickFindLeads()
		.typeFirstName(fName)
		.clickFindButton()
		.clickLeadID()
		.clickEditLead()
		.typeFirstName(fName1)
		.clickUpdateButton()
		.getLeadID()
		.clickFindLeads()
		.typeLeadID()
		.clickFindButton()
		.clickLeadID()
		.verifyFirstName(fName1);
		
	}
}
