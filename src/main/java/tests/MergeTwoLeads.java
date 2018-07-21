package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyHome;
import lib.selenium.PreAndPost;

public class MergeTwoLeads extends PreAndPost {
	
	@BeforeTest
	public void setVal() {
		testCaseName="MergeLead";
		testDescription="Merge 2 Leads";
		excelName="Merge2Leads";
		nodeName="Leads";
		author="Jawa";
		category="Sanity";
	}
	
	@Test(dataProvider="TST")
	public void editLead(String fName,String fName1) throws InterruptedException{
		
		new MyHome(driver, test)
		.clickLeads()
		.clickMergeLeads()
		.clickSrc()
		.typeFirstName(fName)
		.clickFindButton()
		.selectLead()
		.clickDest()
		.typeFirstName(fName1)
		.clickFindButton()
		.selectLead()
		.clickMergeButton()
		.clickFindLeads()
		.typeIDaftMerge()
		.clickFindButton()
		.verifyAfterMerge();
		
	}
}
