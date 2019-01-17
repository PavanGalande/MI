package com.pharmeasy.MercuryUI.Page;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PurchaseEntryPage {
	WebDriver driver;
	public PurchaseEntryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//@FindBy(linkText="/purchase")
	//private WebElement purchase;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[1]/app-mainnavigation/div/a[3]/img")
	private WebElement purchase;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/div/div/div[2]/div[3]/button")
	private WebElement NewEntry;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-selectvendor/div/div[2]/ul/li[1]/div/div[1]")
	private WebElement SelectVendor;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-selectvendor/div/div[3]/button[2]")
	private WebElement Continue;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[1]/div[1]/div/input")
	private WebElement InvoiceNumber;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[1]/div[2]/table/tbody/tr/td[1]/input")
	private WebElement MedicineName;
	
	@FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[1]/div[2]/table/tbody/tr/td[1]/input")
	private WebElement Enter;
	
	@FindBy(className="showautosuggest")
    private WebElement Medicinename;
	
    @FindBy(id="search")
    private WebElement Entername;
    

   // @FindBy(xpath="//input[@type='text']")
    //private WebElement quantity;
    

    @FindBy(xpath="//div[@class='invoicemap-main-table']/table//tr/td[7]")
    private WebElement quantity;
    
    @FindBy(xpath="//div[@class='invoicemap-main-table']/table//tr/td[12]")
    private WebElement purchaserate;
    
    @FindBy(xpath="//button[text()='Review']")
    private WebElement review;
    
    @FindBy(xpath="//button[text()='Create']")
    private WebElement Create;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[2]/div/div[2]/div/button")
    private WebElement printbarcode;
    
    @FindBy(xpath="//button[text()='Print Putaway']")
    private WebElement printputaway;
    
    @FindBy(xpath="//button[text()=' Make Inventory Live']")
    private WebElement makeinventorylive;
    
    @FindBy(xpath="//input[@placeholder='Search Medicine']")
    private WebElement medicinename;
    
    
    @FindBy(xpath="//input[@placeholder='Search Vendor Name']")
    private WebElement Searchvendorname;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/div/section/div[1]/div[2]/div[5]")
    private WebElement Selectgatepass;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-uploadvendorbill/div/div[2]/ul/li/div/div[2]/div/input")
    private WebElement Selectfile;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-uploadvendorbill/div/div[3]/button[1]")
    private WebElement uploadandcontinue;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-medicinemapper/div/div[1]/div[4]/button[2]")
    private WebElement Confirmandproceed;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[2]/div/div[2]/div/button[1]")
    private WebElement Review;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[2]/div/div[2]/div/button[1]")
    private WebElement Create1;
    
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[2]/div/div[2]/div/button")
    private WebElement PrintBarcode;
    
    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[2]/div/div[2]/div/button[2]")
    private WebElement PrintPutaway;

    @FindBy(xpath="/html/body/app-root/div/div[2]/div[2]/div/app-purchasesbase/div/div[2]/app-purchases/app-modal/div/div[2]/div/app-invoicechecker/div/div[2]/div/div[2]/div/button[3]")
    private WebElement MakeInventoryLive;
    

    @FindBy(xpath="/html/body/app-root/div/ng2-toasty/div/ng2-toast/div/div[2]")
    private WebElement taostMessage;

    
    
    
    
    
    
    
  
    
  
    
    
    
    
    
    
    
   
   
    
    
  
	
	
	
	
	


	public void clickpurchaseentry() throws InterruptedException, AWTException
	 {
		 
		 
		 int data1 = excel.getrowcount("./testdata/webTestData.xlsx", "PurchaseEntry");
		 System.out.println(data1);
		 driver.get("https://qa.app.mercury.pharmeasy.in/gatepass");
		 for(int i=1;i<=data1;i++)
		 {
		 Thread.sleep(2000);
		 driver.get("http://qa.app.mercury.pharmeasy.in/purchase/entry");
		 System.out.println("clicked");
		 Thread.sleep(10000);
		 NewEntry.click();
		 Thread.sleep(2000);
		 SelectVendor.click();
		 Thread.sleep(2000);
		 Continue.click();
		 Thread.sleep(2000);
		 String data = excel.getcellvalue("./testdata/webTestData.xlsx", "PurchaseEntry", i, 0);
		 System.out.println(data);
		 InvoiceNumber.sendKeys(data);
		 Thread.sleep(2000);
		 Medicinename.click();
		 System.out.println("test");
		 Thread.sleep(4000);
		 String medname = excel.getcellvalue("./testdata/webTestData.xlsx", "PurchaseEntry", i, 1);
		 //Entername.sendKeys("hgh");
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 medicinename.sendKeys(medname);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Thread.sleep(4000);
		 //System.out.println( driver.findElement(By.id("search")));
		 medicinename.sendKeys(Keys.ENTER);
		 System.out.println("done");
		 Thread.sleep(2000);
		 //Entername.sendKeys("XBEND SUSP");
		 System.out.println("test");
		 //MedicineName.sendKeys("XBEND SUSP");	
		// quantity.click();
		 Thread.sleep(3000);
		 Actions actions = new Actions(driver);
	     actions.moveToElement(quantity);
	     actions.click();
	     actions.sendKeys("5");
	     actions.build().perform();
		 Thread.sleep(4000);
		 //quantity.sendKeys("5");
		 
		 Actions actions1 = new Actions(driver);
	     actions.moveToElement(purchaserate);
	     actions.click();
	     actions.sendKeys("10");
	     actions.build().perform();
		 Thread.sleep(4000);
		 review.click();
		 Thread.sleep(3000);
		 Create.click();
		 Thread.sleep(6000);
		 printbarcode.click();
		 Thread.sleep(8000);
		 printputaway.click();
		 Thread.sleep(8000);
		 makeinventorylive.click();
		 Thread.sleep(20000);
		 }
	 }
		 
		 public void Fileupload() throws InterruptedException
		 {
			 Thread.sleep(2000);
			 driver.get("http://qa.app.mercury.pharmeasy.in/purchase/entry");
			 System.out.println("clicked");
			 Thread.sleep(5000);
			 Searchvendorname.sendKeys("Test Vendor");
			 Searchvendorname.sendKeys(Keys.ENTER);
			 Thread.sleep(2000);
			 Selectgatepass.click();
			 Thread.sleep(3000);
			 Selectfile.sendKeys("/Users/pavan/Downloads/convertcsvpositive.csv");
			 System.out.println("after choosefile");
			 Thread.sleep(3000);
			 uploadandcontinue.click();
			 Thread.sleep(10000);
			 Confirmandproceed.click();
			 Thread.sleep(8000);
			 Create1.click();
			 Thread.sleep(8000);
			 PrintBarcode.click();
			 Thread.sleep(3000);
			 taostMessage.click();
			 System.out.println("Clicked Print barcode");
			 Thread.sleep(8000);
             PrintPutaway.click();
             System.out.println("Clicked Print putaway");
             Thread.sleep(8000);
             MakeInventoryLive.click();
             System.out.println("Clicked Make Inventory Live");
             Thread.sleep(8000);
             
			 
			 //proceed.click();
			 
			 
			 
			 
		 }
	 
		 
	 }
	//*[@id="search"]
	

	

