package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHome;
import lib.selenium.PreAndPost;

public class DeleteALead extends PreAndPost {
	
	@BeforeTest
	public void setVal() {
		testCaseName="DeleteLead";
		testDescription="Search and Delete a Lead";
		excelName="DelALead";
		nodeName="Leads";
		author="Jawa";
		category="Regression";
	}
	
	@Test(dataProvider="TST")
	public void editLead(String fName){
		
		new MyHome(driver, test)
		.clickLeads()
		.clickFindLeads()
		.typeFirstName(fName)
		.clickFindButton()
		.clickLeadID()
		.getLeadID()
		.clickDelete()
		.clickFindLeads()
		.typeLeadID()
		.verifyAfterMerge();		
	}
}
