package testBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
	public static WebDriver Test_Base_Common_Driver;
	public static WebDriverWait Common_Driver_Wait;

	@Parameters({ "Browser", "URL" })
	@BeforeClass(alwaysRun = true)
	public void Load_Browser(@Optional("FireFox") String Browser,
			String URL) {
		Open_Browser(Browser, URL);
	}

	@AfterMethod(alwaysRun = true)
	public void Failure_Case(ITestResult Result) {
		if (Result.getStatus() == ITestResult.FAILURE) {
			Take_Snapshot_As_Attachment(Test_Base_Common_Driver, Result.getName());
		}
	}

	@AfterTest(alwaysRun = true)
	public void Quite_Browser() {
		// TODO Auto-generated method stub
		//Test_Base_Common_Driver.quit();
	}

	public void Open_Browser(String Browser, String URL) {
		Browser_Type(Browser);
		Test_Base_Common_Driver.manage().window().maximize();
		Test_Base_Common_Driver.get(URL);
	}

	public void Browser_Type(String Explorer) {
		if (Explorer != null) {
			if (Explorer.toLowerCase().trim().contentEquals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\resources\\drivers\\geckodriver.exe");
				Test_Base_Common_Driver = new FirefoxDriver();
			}
		}
	}

	public void Take_Snapshot_As_Attachment(WebDriver Bug_Driver, String Method_Name) {
		File SnapShot = ((TakesScreenshot) Bug_Driver).getScreenshotAs(OutputType.FILE);
		try {
			DateTimeFormatter DTF = DateTimeFormatter.ofPattern("HH-mm-ss-SSS");
			LocalTime Now_Time = LocalTime.now();
			String Exec_Time = DTF.format(Now_Time);
			FileUtils.copyFile(SnapShot,
					new File(Attachment_Path_Create() + "\\" + Method_Name + "_Time_" + Exec_Time + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Something wrong while get snapshot, please check Method ... " + Method_Name);
		}
	}

	public String Attachment_Path_Create() {
		DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate Now_Date = LocalDate.now();
		String Exec_Date = DTF.format(Now_Date);
		File Attachment_Path = new File(System.getProperty("user.dir") + "\\Snapshots\\" + Exec_Date);
		if (!Attachment_Path.exists()) {
			Attachment_Path.mkdir();
		}
		return Attachment_Path.getAbsolutePath();
	}
}
