package com.pharmeasy.MercuryUI.Page;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.generic.excel;
import com.pharmeasy.MercuryUI.Base.TestBase;
import com.pharmeasy.MercuryUI.ExcelReader.ExcelReader;



public class GatepassPage extends TestBase  {
	//private static final WebElement Errormessage = null;



	//WebDriver driver;
	//private static Logger Log = Logger.getLogger(Gatepasspage.class.getName());
	public GatepassPage()
	{
		//DOMConfigurator.configure("log4j.xml");
		PageFactory.initElements(driver, this);
	}
	
	WebDriverWait wait = new WebDriverWait(driver,60);
	@FindBy(xpath="//span[text()='Gate Pass']")
	private WebElement next;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/div/div[2]/div[4]/button")
	//@FindBy(xpath="//span[text()='+ New Entry']")
	private WebElement next1;
	
	@FindBy(xpath="//*[@id='toasty']/ng2-toast/div/div[2]/span")
	private WebElement Errormessage;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-selectvendor/div/div[2]/ul/li[1]/div/div[1]")
	private WebElement selectvendor;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-selectvendor/div/div[3]/button[2]")
	private WebElement Continue;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-gatepassentry/div/div/div[2]/form/div[1]/app-entryform/div/div[1]/div[1]/div/input")
	private WebElement InvoiceNumber;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-gatepassentry/div/div/div[2]/form/div[1]/app-entryform/div/div[1]/div[2]/div/input")
	private WebElement InvoiceDate; 
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-gatepassentry/div/div/div[2]/form/div[1]/app-entryform/div/div[1]/div[3]/div/input")
	private WebElement Amount;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-gatepassentry/div/div/div[2]/form/div[1]/app-entryform/div/div[1]/div[4]/div/button[2]")
	private WebElement Cartons;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-gatepassentry/div/div/div[2]/form/button")
	private WebElement CreateGatepass;
	
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-gatepassbase/div/div[2]/app-gatepass/div/app-modal/div/div[2]/div/app-gatepassentry/div/div/div[2]/form/div[1]/app-entryform/div/div[1]/div[7]/div/label/span")
	private WebElement POavailable;
	
	
	
	//*[@id="thatForm"]/div[1]/app-entryform/div/div[1]/div[7]/div/label/span
	
	
	
	
	
	
	
	//@FindBy(xpath="//*[@id="thatForm"]/div[1]/app-entryform/div/div[1]/div[6]/div/label/span")
	//private WebElement interstate;
	
	

	public void clickgatepass() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 //Assert.assertTrue(next.isDisplayed());
		 //Assert.assertFalse(next.isDisplayed());
		 next.click();
	 }
	
	public void clicknext1() throws InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		Thread.sleep(2000);
		next1.click();
	}
	
	 @SuppressWarnings("static-access")
	public void Creategatepass(String invNum) throws InterruptedException
	 {
		//DOMConfigurator.configure("log4j.xml");
		/*selectvendor.click();
		//Log.info("vendor is selected");
		Thread.sleep(2000);
		Continue.click();
		//File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
		Thread.sleep(2000);*/
		//Log.info("Clicked on continue");
		// ExcelReader excel = new ExcelReader();
		 
		//int data1 = excel.getrowcount("./testdata/webTestData.xlsx", "Gatepass");
		 //System.out.println(data1);
		 
		 
		 
		 driver.get("https://qa.app.mercuryonline.co/gatepass");
		 
		 
		
			 
			 
			 
			 Thread.sleep(3000);
			 String title1=driver.getTitle();
			 System.out.println(title1);
			 next1.click();
			 System.out.println("next has been clicked");
			 //driver.getTitle();
			 String title=driver.getTitle();
			 System.out.println(title);
			 //Assert.assertEquals("Mercury", driver.getTitle());
			 wait.until(ExpectedConditions.visibilityOf(selectvendor));
			 //Thread.sleep(3000);
			 //Assert.assertTrue(selectvendor.isDisplayed());
			 selectvendor.click();
			 //Log.info("vendor is selected");
			 Thread.sleep(2000);
			 //Assert.assertTrue(Continue.isDisplayed());
			 Continue.click();
			//File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
			 Thread.sleep(2000);
			 //String data = excel.getcellvalue("./testdata/webTestData.xlsx", "Gatepass", i, 0);
			 //System.out.println(data);
			 //Assert.assertTrue(InvoiceNumber.isDisplayed());
			 InvoiceNumber.sendKeys(invNum);
			 Thread.sleep(2000);
			 //Assert.assertTrue(InvoiceDate.isDisplayed());
			 //System.out.println(InvoiceDate);
			 InvoiceDate.sendKeys("22/05/2018");
			 Thread.sleep(2000);
			 //Assert.assertTrue(Amount.isDisplayed());
			 Amount.sendKeys("100");
			 Thread.sleep(2000);
			 POavailable.click();
			 Thread.sleep(3000);
			 //Assert.assertTrue(Cartons.isDisplayed());
			 Cartons.click();
			 //Assert.assertTrue(CreateGatepass.isDisplayed());
			 CreateGatepass.click();
			 Thread.sleep(2000);
		 
		 
			//Log.info("Entered the invoice number");
		
		//InvoiceNumber.sendKeys("ddffgdfgdfgkjkjkj");
		//Log.info("Entered the invoice number");
		//InvoiceDate.sendKeys("22/05/2018");
		//Amount.sendKeys("100");
		//Cartons.click();
		//CrateGatepass.click();
		
	 }
	 
	 @SuppressWarnings("static-access")
		public void Createnegativegatepass() throws InterruptedException
		 {
			//DOMConfigurator.configure("log4j.xml");
			/*selectvendor.click();
			//Log.info("vendor is selected");
			Thread.sleep(2000);
			Continue.click();
			//File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
			Thread.sleep(2000);*/
			//Log.info("Clicked on continue");
			// ExcelReader excel = new ExcelReader();
			 
			//int data1 = excel.getrowcount("./testdata/webTestData.xlsx", "Gatepass");
			 //System.out.println(data1);
			 
			 
			 
			 driver.get("https://qa.app.mercuryonline.co/gatepass");
			 
			 
			
				 
				 
				 
				 Thread.sleep(3000);
				 String title1=driver.getTitle();
				 System.out.println(title1);
				 next1.click();
				 System.out.println("next has been clicked");
				 //driver.getTitle();
				 String title=driver.getTitle();
				 System.out.println(title);
				 //Assert.assertEquals("Mercury", driver.getTitle());
				 wait.until(ExpectedConditions.visibilityOf(selectvendor));
				 //Thread.sleep(3000);
				 //Assert.assertTrue(selectvendor.isDisplayed());
				 selectvendor.click();
				 //Log.info("vendor is selected");
				 Thread.sleep(2000);
				 //Assert.assertTrue(Continue.isDisplayed());
				 Continue.click();
//Log.info("vendor is selected");
			 Thread.sleep(2000);
			
			//File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(screenshotFile, new File("D:\\SoftwareTestingMaterial.png"));
			 //Thread.sleep(2000);
			 //String data = excel.getcellvalue("./testdata/webTestData.xlsx", "Gatepass", i, 0);
			 //System.out.println(data);
			 //Assert.assertTrue(InvoiceNumber.isDisplayed());
			 //InvoiceNumber.sendKeys(data);
			 //Thread.sleep(2000);
			 //Assert.assertTrue(InvoiceDate.isDisplayed());
			 //System.out.println(InvoiceDate);
			 //InvoiceDate.sendKeys("22/05/2018");
			 //Thread.sleep(2000);
			 //Assert.assertTrue(Amount.isDisplayed());
			 //Amount.sendKeys("100");
			 //Thread.sleep(2000);
			 //Assert.assertTrue(Cartons.isDisplayed());
			 //Cartons.click();
			 //Assert.assertTrue(CreateGatepass.isDisplayed());
			 Thread.sleep(3000);
			 CreateGatepass.click();
             Thread.sleep(3000);
             
			 String text = Errormessage.getText();
			 System.out.println(text+"printtest");
			 //assertEquals("Field can/’t be empty.", text);
			 System.out.println("passed");
			 
			//*[@id="toasty"]/ng2-toast/div/div[2]/span
			 Thread.sleep(2000);
		 //}
	 //public void getscreenshot() throws Exception 
     //{
             //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          //The below method will save the screen shot in d drive with name "screenshot.png"
             //FileUtils.copyFile(scrFile, new File(""));
     //}
	
}
}
