package com.pharmeasy.MercuryUI.Gatepass;

import com.pharmeasy.MercuryUI.Base.TestBase;
import com.pharmeasy.MercuryUI.Gatepass.*;
import com.pharmeasy.MercuryUI.Page.GatepassPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;



public class CreateGatepass extends TestBase {
	
	
	@DataProvider(name="getTestData")
	public String[][] getTestData(){
		String[][] testdata = ReadExcel("Gatepass", "webTestData.xlsx");
		return testdata ;
	}
	
	
	 


	@Test (dataProvider="getTestData")
	public void createGatepass(String invNum) throws InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		
		//Loginpage lp = new Loginpage(driver);
		GatepassPage gp = new GatepassPage();
		//lp.clicklogin();
		//lp.windowhandle();
		
		//gp.clickgatepass();
		//gp.clicknext1();
		Thread.sleep(2000);
 		gp.Creategatepass(invNum);
 		//Assert.assertEquals("bgbg", "gr");
 		
 		
 		
		}
	
}
