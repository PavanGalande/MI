package com.pharmeasy.MercuryUI.PurchaseEntry;

import com.pharmeasy.MercuryUI.Base.TestBase;
import com.pharmeasy.MercuryUI.Gatepass.*;
import com.pharmeasy.MercuryUI.Page.GatepassPage;
import com.pharmeasy.MercuryUI.Page.PurchaseEntryPage;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;



public class PurchaseEntry extends TestBase {
	
	
	@DataProvider(name="getTestData")
	public String[][] getTestData(){
		//String[][] testdata = ReadExcel("Sheet1", "Sheet1.xlsx");
		String[][] testdata = ReadExcel("PurchaseEntry", "webTestData.xlsx");
		
		//String[][] testdata = ReadExcel("Gatepass", "webTestData.xlsx");
		System.out.println(testdata);
		
		return testdata ;
	}

	@Test (dataProvider="getTestData")
	public void purchaseEntry(String invNum, String medName, String test) throws InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		System.out.println(test);
		//Loginpage lp = new Loginpage(driver);
		//GatepassPage gp = new GatepassPage();
		PurchaseEntryPage pe = new PurchaseEntryPage();
		//lp.clicklogin();
		//lp.windowhandle();
		
		//gp.clickgatepass();
		//gp.clicknext1();
		Thread.sleep(2000);
		pe.clickpurchaseentry(invNum, medName);
 		//gp.Creategatepass(invNum);
 		//Assert.assertEquals("bgbg", "gr");
 		
 		
 		
		}
	
}