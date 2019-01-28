package web.demo.bm.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import web.demo.bm.webpageclasses.SC1;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC1 extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;	public static final int datasetsLength = 1;

	public TC1() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC1.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc1.properties");
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, SC1.projectName);
		test = reports.startTest("TC1");
	}
	
	public void setUP() throws Exception {
		String primaryInfo = SC1.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(new JSONObject(primaryInfo).optString("browser_type"), configFileObj);
	}

	public void SC1Test(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		SC1 objSC1 = PageFactory.initElements(driver, SC1.class);
		testLogHeader(test, "Verify SC1 page");
String text1 = objSC1.clkALogin_292259();
		if(text1.equalsIgnoreCase(configFileObj.getProperty("Login"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Clicked on : " + configFileObj.getProperty("Login"+ i + datasetScreencount));
			printSuccessLogAndReport(test, logger,  "Validated Link Text : " + configFileObj.getProperty("Login"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Link Text is not displayed  : " + configFileObj.getProperty("Login"+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		isElementDispalyed = true;
		for(int datasets = 1; datasets <= SC1.datasetsLength; datasets++) {
			if(!isElementDispalyed) return;			
			setUP();
			if(isElementDispalyed) { SC1Test(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}