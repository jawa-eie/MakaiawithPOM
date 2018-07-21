package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHome;
import lib.selenium.PreAndPost;

public class DuplicateALead extends PreAndPost {
	
	@BeforeTest
	public void setVal() {
		testCaseName="DuplicateLead";
		testDescription="Search and Create a Duplicate Lead";
		excelName="DupALead";
		nodeName="Leads";
		author="Jawa";
		category="Regression";
	}
	
	@Test(dataProvider="TST")
	public void editLead(String fName,String cName){
		
		new MyHome(driver, test)
		.clickLeads()
		.clickFindLeads()
		.typeFirstName(fName)
		.clickFindButton()
		.clickLeadID()
		.clickDuplicate()
		.typeCompName(cName)
		.clickCreateButton()
		.getLeadID()
		.clickFindLeads()
		.typeLeadID()
		.clickFindButton()
		.clickLeadID()
		.verifyCompName(cName);
		
		
	}
}
