package com.pharmeasy.MercuryUI.Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pharmeasy.MercuryUI.ExcelReader.ExcelReader;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;



  

public class TestBase {
	//public WebDriver driver;
	private JavascriptExecutor js  = null;
	
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver ;

	public static ExtentReports extent ;
	public static ExtentTest Test ;
	public static ITestResult Result ;
	public Properties OR = new Properties();
	public Properties APP = new Properties();
	
	
	public void LoadfromORproperties() throws IOException{
		File path = new File(System.getProperty("user.dir")+"/src/main/java/com/pharmeasy/MercuryUI/Config/OR.properties");
		FileInputStream fis = new FileInputStream(path);
		OR.load(fis);
	}
	
	/*public void LoadfromAPPproperties() throws IOException{
		File path = new File(System.getProperty("user.dir")+"//src//main//java//com//c2info//RMS_Config//APP.properties");
		FileInputStream fis = new FileInputStream(path);
		APP.load(fis);
	}*/
	
	static{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/main/java/com/pharmeasy/MercuryUI/reports/"+formatter.format(calendar.getTime())+".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	public String[][] ReadExcel(String SheetName,String ExcelName){
		String path = System.getProperty("user.dir")+"/src/main/java/com/pharmeasy/MercuryUI/Data/webTestData.xlsx";
		ExcelReader excel = new ExcelReader(path);
		String[][] TestData = excel.getdatafromSheet(SheetName, ExcelName);
		return TestData;
		
	}
	
	
	public void init() throws IOException{
		LoadfromORproperties();
		//LoadfromAPPproperties();
		selectBrowser(OR.getProperty("BrowserName"));
		getBaseUrl(OR.getProperty("URL"));
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//log4j.properties");
		
		
	}
	
	public void selectBrowser(String BrowserName){
		if(BrowserName.equalsIgnoreCase("firefox")){
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			//waitForElementToLoad();
		
		}
		else if(BrowserName.equalsIgnoreCase("chrome")){
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
			System.setProperty("webdriver.chrome.driver", "/Users/pavan/Documents/docu/workspace1/Mercury/src/pom/chromedriver");
			driver = new ChromeDriver();
			//waitForElementToLoad();
			
		}
		else if(BrowserName.equalsIgnoreCase("htmlunit")){
			//driver = new HtmlUnitDriver() ;
			//waitForElementToLoad();
		}
	}
	
	public void getBaseUrl(String BaseUrl){
		driver.get(BaseUrl);
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	/* @BeforeTest
	 public void startReport(){
	 //ExtentReports(String filePath,Boolean replaceExisting) 
	 //filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
	 //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
	 //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
	 //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		  extent = new ExtentReports("/Users/pavan/Documents/docu/workspace1/Mercury1/sample.html", true);

	        // creates a toggle for the given test, adds all log events under it    
	         

	 }*/
	 
	
	
	/*@BeforeMethod
	public void precondition()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/pavan/Documents/docu/workspace1/Mercury/src/pom/chromedriver");
    	driver = new ChromeDriver();
 		//driver.manage().window().maximize();
 		js = (JavascriptExecutor) driver;
 		//QA
 		driver.get("https://qa.app.mercuryonline.co/login");
 		setItemInLocalStorage("user","{\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJuZWJ1bGEiLCJhdWQiOiJtZXJjdXJ5IiwidWlkIjoiNmY5ZmIzMzktMGY2ZS00ZTBlLWExMjYtNTljNDE5MGM5NWYxIiwiaXNzIjoiUGhhcm1FYXN5LmluIiwibmFtZSI6IlBhdmFuIiwic3RvcmUiOiIzNTRhMTNlYi1iZDlkLTRhNmMtYTAyYi04YWFjMGRjNTgxNWQiLCJzY29wZXMiOlsid2gtc3VwZXItYWRtaW4iXSwiZXhwIjoxNTQ4MTQzNDM4LCJ1c2VyIjoicGF2YW4uZ2FsYW5kZUBwaGFybWVhc3kuaW4iLCJ0ZW5hbnQiOiJ0aDAxNCJ9.fThXKwPzdC1TAWwrFF5mrWv4REGMOY-aKGX4KTW5GY6-8RLGkTR5utRrXExsdBVgOBWHNM9Ugg0TPai1tB8gyQ\",\"email\":\"pavan.galande@pharmeasy.in\",\"name\":\"Pavan\",\"displayName\":\"Pavan\",\"mobile\":\"1234567890\",\"roles\":[{\"id\":\"wh-super-admin\",\"description\":\"Super Administrator\"}],\"currentWarehouse\":\"JUST TEST\",\"warehouses\":[{\"id\":2,\"name\":\"Bangalore Picker Test\",\"tenant\":\"th00002\"},{\"id\":3,\"name\":\"Mumbai Picker test\",\"tenant\":\"th00001\"},{\"id\":10,\"name\":\"Prod Mumbai\",\"tenant\":\"th024\"},{\"id\":46,\"name\":\"JUST TEST\",\"tenant\":\"th003\"},{\"id\":49,\"name\":\"NEW WAREHOUSE\",\"tenant\":\"th014\"},{\"id\":89,\"name\":\"StockTransferTest-Thea\",\"tenant\":\"th0033\"},{\"id\":95,\"name\":\"StockTransferWithRacker\",\"tenant\":\"th0034\"},{\"id\":101,\"name\":\"ISMAIL WH\",\"tenant\":\"th0114\"}],\"currentArsenal\":null,\"arsenal\":null,\"currentStore\":\"THEA RETAIL1\",\"currentStoreId\":\"7dd83565-1c91-4211-9a9b-f1c2269b2b23\",\"stores\":[{\"id\":\"7dd83565-1c91-4211-9a9b-f1c2269b2b23\",\"name\":\"\"},{\"id\":\"7dd83565-1c91-4211-9a9b-f1c2269b2b23\",\"name\":\"Retailer Bangalore Bng\"},{\"id\":\"57838bd8-5f4e-414e-bd0d-d779dd677c99\",\"name\":\"Test\"},{\"id\":\"25ba2c94-f9fc-4851-bef7-fd15ac3cf233\",\"name\":\"asfad1\"},{\"id\":\"47c09e5b-481b-4c0b-90ed-656c1eba8342\",\"name\":\"Retailer99\"},{\"id\":\"82162c35-6475-4ee5-b62d-a903305aeb91\",\"name\":\"Retailer6\"},{\"id\":\"82c9e82d-8198-485f-9063-b1f504e65574\",\"name\":\"Retiluuil\"},{\"id\":\"7ca9cd09-3258-490b-86fd-46c0cf2ab332\",\"name\":\"Test 180418\"},{\"id\":\"dcbc397e-4ba6-4c70-bdd2-ede3c0bf5347\",\"name\":\"testretailer123\"},{\"id\":\"e73a856b-0d4e-422e-aff9-11c2e68a2a76\",\"name\":\"Really working\"},{\"id\":\"0eee4f71-cc96-4af6-8ea7-6d263ac3aa3d\",\"name\":\"pavan12345\"},{\"id\":\"cc3bd860-fb58-4781-8ec0-08c42e99fab9\",\"name\":\"pavan12345\"},{\"id\":\"756e35eb-dc66-4040-9300-7768a8e4698f\",\"name\":\"pavan12345\"},{\"id\":\"57da0de5-b5ba-4c72-8b9f-a192af626fd3\",\"name\":\"pavan12345\"},{\"id\":\"d15d5660-5acd-4b04-b42f-a310cae862aa\",\"name\":\"11111\"},{\"id\":\"67460b7f-edac-433c-ae2e-d8fe7073c404\",\"name\":\"11111\"},{\"id\":\"423b73eb-245b-4433-9b2b-2c936291f65a\",\"name\":\"11111\"}],\"id\":\"6f9fb339-0f6e-4e0e-a126-59c4190c95f1\",\"status\":null,\"currentWarehouseId\":46,\"currentArsenalId\":null,\"fetcherEnabled\":false,\"pickerEnabled\":false,\"lastBreakTime\":\"2018-08-30T12:31:49\"}");
 		//QA
 		setItemInLocalStorage("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJuZWJ1bGEiLCJhdWQiOiJtZXJjdXJ5IiwidWlkIjoiNmY5ZmIzMzktMGY2ZS00ZTBlLWExMjYtNTljNDE5MGM5NWYxIiwiaXNzIjoiUGhhcm1FYXN5LmluIiwibmFtZSI6IlBhdmFuIiwic3RvcmUiOiIzNTRhMTNlYi1iZDlkLTRhNmMtYTAyYi04YWFjMGRjNTgxNWQiLCJzY29wZXMiOlsid2gtc3VwZXItYWRtaW4iXSwiZXhwIjoxNTQ4MTQzNDM4LCJ1c2VyIjoicGF2YW4uZ2FsYW5kZUBwaGFybWVhc3kuaW4iLCJ0ZW5hbnQiOiJ0aDAxNCJ9.fThXKwPzdC1TAWwrFF5mrWv4REGMOY-aKGX4KTW5GY6-8RLGkTR5utRrXExsdBVgOBWHNM9Ugg0TPai1tB8gyQ");
 		//Prod
 		//setItemInLocalStorage("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJuZWJ1bGEiLCJhdWQiOiJtZXJjdXJ5IiwidWlkIjoiZjkyZjE0ZDUtNmIwMC00ODJiLWExMDgtYmY1ZWE2NDU2ZDVlIiwiaXNzIjoiUGhhcm1FYXN5LmluIiwibmFtZSI6IlBhdmFuIFNocmltYW50IEdhbGFuZGUiLCJzdG9yZSI6IjM1NGExM2ViLWJkOWQtNGE2Yy1hMDJiLThhYWMwZGM1ODE1ZCIsInNjb3BlcyI6WyJ3aC1zdXBlci1hZG1pbiJdLCJleHAiOjE1MzU0NTM4OTQsInVzZXIiOiJwYXZhbi5nYWxhbmRlQHBoYXJtZWFzeS5pbiIsInRlbmFudCI6InRoMDE0In0.6aIZHfdDKBX9C6Ggjw9CJZoXGE6fsZ2nAWmH3U4C8Y8wp0STEUIdugSlFw6siz_8xNZNmBRxtp9CSdUIGuYMig");
 		//driver.get("http://qa.app.mercury.pharmeasy.in/gatepass");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
	}
	*/
	
	
	public void setItemInLocalStorage(String item, String value) {
	    js.executeScript(String.format(
	        "window.sessionStorage.setItem('%s', '%s');", item, value));

	  }


	public void getResult(ITestResult Result) throws IOException{
        if(Result.getStatus()==ITestResult.SUCCESS){
            Test.log(Status.PASS, Result.getName()+" Test is Passed");
            
        }
        else if(Result.getStatus()==ITestResult.FAILURE){
            Test.log(Status.FAIL, Result.getName()+" Test is Failed");
            //Test.log(Status.FAIL, Test.addScreenCaptureFromPath(getScreenshot(Thread.currentThread().getStackTrace()[1].getMethodName())));
            
        }
        else if(Result.getStatus()==ITestResult.SKIP){
            Test.log(Status.SKIP, Result.getName()+" Test is Skipped");
            //writeExcel("TC", "TC.xlsx",Result.getName(),"SKIPPED");
        }
        else if(Result.getStatus()==ITestResult.STARTED){
            Test.log(Status.INFO, Result.getName()+" Test is Started");
        }
    }
	
	private String getScreenshot(String methodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@BeforeMethod()
	public void beforeMethod(Method Result) throws IOException{
		Test = extent.createTest(Result.getName());
		Test.log(Status.INFO, Result.getName()+" Test is Started");
		System.out.println(Test);
		LoadfromORproperties();
		//LoadfromAPPproperties();
		selectBrowser(OR.getProperty("BrowserName"));
		//getBaseUrl(OR.getProperty("URL"));
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//log4j.properties");
	
 		//driver.manage().window().maximize();
 		js = (JavascriptExecutor) driver;
 		//QA
 		driver.get("https://qa.app.mercuryonline.co/login");
 		setItemInLocalStorage("user","{\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJuZWJ1bGEiLCJhdWQiOiJtZXJjdXJ5IiwidWlkIjoiNmY5ZmIzMzktMGY2ZS00ZTBlLWExMjYtNTljNDE5MGM5NWYxIiwiaXNzIjoiUGhhcm1FYXN5LmluIiwibmFtZSI6IlBhdmFuIiwic3RvcmUiOiIzNTRhMTNlYi1iZDlkLTRhNmMtYTAyYi04YWFjMGRjNTgxNWQiLCJzY29wZXMiOlsid2gtc3VwZXItYWRtaW4iXSwiZXhwIjoxNTQ4MTQzNDM4LCJ1c2VyIjoicGF2YW4uZ2FsYW5kZUBwaGFybWVhc3kuaW4iLCJ0ZW5hbnQiOiJ0aDAxNCJ9.fThXKwPzdC1TAWwrFF5mrWv4REGMOY-aKGX4KTW5GY6-8RLGkTR5utRrXExsdBVgOBWHNM9Ugg0TPai1tB8gyQ\",\"email\":\"pavan.galande@pharmeasy.in\",\"name\":\"Pavan\",\"displayName\":\"Pavan\",\"mobile\":\"1234567890\",\"roles\":[{\"id\":\"wh-super-admin\",\"description\":\"Super Administrator\"}],\"currentWarehouse\":\"JUST TEST\",\"warehouses\":[{\"id\":2,\"name\":\"Bangalore Picker Test\",\"tenant\":\"th00002\"},{\"id\":3,\"name\":\"Mumbai Picker test\",\"tenant\":\"th00001\"},{\"id\":10,\"name\":\"Prod Mumbai\",\"tenant\":\"th024\"},{\"id\":46,\"name\":\"JUST TEST\",\"tenant\":\"th003\"},{\"id\":49,\"name\":\"NEW WAREHOUSE\",\"tenant\":\"th014\"},{\"id\":89,\"name\":\"StockTransferTest-Thea\",\"tenant\":\"th0033\"},{\"id\":95,\"name\":\"StockTransferWithRacker\",\"tenant\":\"th0034\"},{\"id\":101,\"name\":\"ISMAIL WH\",\"tenant\":\"th0114\"}],\"currentArsenal\":null,\"arsenal\":null,\"currentStore\":\"THEA RETAIL1\",\"currentStoreId\":\"7dd83565-1c91-4211-9a9b-f1c2269b2b23\",\"stores\":[{\"id\":\"7dd83565-1c91-4211-9a9b-f1c2269b2b23\",\"name\":\"\"},{\"id\":\"7dd83565-1c91-4211-9a9b-f1c2269b2b23\",\"name\":\"Retailer Bangalore Bng\"},{\"id\":\"57838bd8-5f4e-414e-bd0d-d779dd677c99\",\"name\":\"Test\"},{\"id\":\"25ba2c94-f9fc-4851-bef7-fd15ac3cf233\",\"name\":\"asfad1\"},{\"id\":\"47c09e5b-481b-4c0b-90ed-656c1eba8342\",\"name\":\"Retailer99\"},{\"id\":\"82162c35-6475-4ee5-b62d-a903305aeb91\",\"name\":\"Retailer6\"},{\"id\":\"82c9e82d-8198-485f-9063-b1f504e65574\",\"name\":\"Retiluuil\"},{\"id\":\"7ca9cd09-3258-490b-86fd-46c0cf2ab332\",\"name\":\"Test 180418\"},{\"id\":\"dcbc397e-4ba6-4c70-bdd2-ede3c0bf5347\",\"name\":\"testretailer123\"},{\"id\":\"e73a856b-0d4e-422e-aff9-11c2e68a2a76\",\"name\":\"Really working\"},{\"id\":\"0eee4f71-cc96-4af6-8ea7-6d263ac3aa3d\",\"name\":\"pavan12345\"},{\"id\":\"cc3bd860-fb58-4781-8ec0-08c42e99fab9\",\"name\":\"pavan12345\"},{\"id\":\"756e35eb-dc66-4040-9300-7768a8e4698f\",\"name\":\"pavan12345\"},{\"id\":\"57da0de5-b5ba-4c72-8b9f-a192af626fd3\",\"name\":\"pavan12345\"},{\"id\":\"d15d5660-5acd-4b04-b42f-a310cae862aa\",\"name\":\"11111\"},{\"id\":\"67460b7f-edac-433c-ae2e-d8fe7073c404\",\"name\":\"11111\"},{\"id\":\"423b73eb-245b-4433-9b2b-2c936291f65a\",\"name\":\"11111\"}],\"id\":\"6f9fb339-0f6e-4e0e-a126-59c4190c95f1\",\"status\":null,\"currentWarehouseId\":46,\"currentArsenalId\":null,\"fetcherEnabled\":false,\"pickerEnabled\":false,\"lastBreakTime\":\"2018-08-30T12:31:49\"}");
 		//QA
 		setItemInLocalStorage("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJuZWJ1bGEiLCJhdWQiOiJtZXJjdXJ5IiwidWlkIjoiNmY5ZmIzMzktMGY2ZS00ZTBlLWExMjYtNTljNDE5MGM5NWYxIiwiaXNzIjoiUGhhcm1FYXN5LmluIiwibmFtZSI6IlBhdmFuIiwic3RvcmUiOiIzNTRhMTNlYi1iZDlkLTRhNmMtYTAyYi04YWFjMGRjNTgxNWQiLCJzY29wZXMiOlsid2gtc3VwZXItYWRtaW4iXSwiZXhwIjoxNTQ4MTQzNDM4LCJ1c2VyIjoicGF2YW4uZ2FsYW5kZUBwaGFybWVhc3kuaW4iLCJ0ZW5hbnQiOiJ0aDAxNCJ9.fThXKwPzdC1TAWwrFF5mrWv4REGMOY-aKGX4KTW5GY6-8RLGkTR5utRrXExsdBVgOBWHNM9Ugg0TPai1tB8gyQ");
 		//Prod
 		//setItemInLocalStorage("token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJhcHAiOiJuZWJ1bGEiLCJhdWQiOiJtZXJjdXJ5IiwidWlkIjoiZjkyZjE0ZDUtNmIwMC00ODJiLWExMDgtYmY1ZWE2NDU2ZDVlIiwiaXNzIjoiUGhhcm1FYXN5LmluIiwibmFtZSI6IlBhdmFuIFNocmltYW50IEdhbGFuZGUiLCJzdG9yZSI6IjM1NGExM2ViLWJkOWQtNGE2Yy1hMDJiLThhYWMwZGM1ODE1ZCIsInNjb3BlcyI6WyJ3aC1zdXBlci1hZG1pbiJdLCJleHAiOjE1MzU0NTM4OTQsInVzZXIiOiJwYXZhbi5nYWxhbmRlQHBoYXJtZWFzeS5pbiIsInRlbmFudCI6InRoMDE0In0.6aIZHfdDKBX9C6Ggjw9CJZoXGE6fsZ2nAWmH3U4C8Y8wp0STEUIdugSlFw6siz_8xNZNmBRxtp9CSdUIGuYMig");
 		//driver.get("http://qa.app.mercury.pharmeasy.in/gatepass");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
	}
	
	@AfterMethod()
	public void afterMethod(ITestResult Result) throws IOException{
		getResult(Result);
		driver.close();
		
	}
	@AfterClass(alwaysRun=true)
	public void endTest(){
		try {
			//driver.close();
			extent.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No such session found to close the driver");
		}
	}

}
