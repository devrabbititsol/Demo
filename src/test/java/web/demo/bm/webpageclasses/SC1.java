package web.demo.bm.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class SC1 extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":7,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"https://devrabbitdev.com/\",\"report_upload_url\":\"https://192.168.1.142:8080/TAF_Automation_DR/UploadReportFile\",\"project_name\":\"Demo\",\"project_description\":\"desc\",\"project_id\":205,\"module_name\":\"BM\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":348,\"testcase_name\":\"TC3\",\"testcase_id\":416,\"testset_id\":0,\"executed_timestamp\":-1740508536,\"browser_type\":\"chrome\"}";

	public static String projectName = "demo";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public SC1(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//HTML/BODY[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/UL[1]/LI[2]/A[1]")	
	private WebElement	Login_292259A;
	public String clkALogin_292259() {
		waitForExpectedElement(driver, Login_292259A);		
		String text = Login_292259A.getText();
		Login_292259A.click();
		return text;
	}

}