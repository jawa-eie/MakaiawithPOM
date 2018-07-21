package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHome;
import lib.selenium.PreAndPost;

public class CreateALead extends PreAndPost {
	
	@BeforeTest
	public void setVal() {
		testCaseName="CreateLead";
		testDescription="Create a new Lead";
		excelName="CreateALead";
		nodeName="Leads";
		author="Jawa";
		category="Sanity";
	}
	
	@Test(dataProvider="TST")
	public void createLead(String cName,String fName,String lName,String email,String phone){
		
		new MyHome(driver, test)
		.clickLeads()
		.clickCreateLead()
		.typeCompName(cName)
		.typeFirstName(fName)
		.typeLastName(lName)
		.clickCreate()
		.verifyFirstName(fName);
	}
}
