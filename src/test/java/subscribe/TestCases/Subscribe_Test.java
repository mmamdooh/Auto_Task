package subscribe.TestCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Subsribe.Page_Subscribe;
import Subsribe.Page_Subscribe_bh;
import Subsribe.Page_Subscribe_kw;
import testBase.TestBase;

public class Subscribe_Test extends TestBase {
	Page_Subscribe subcribe;
	Page_Subscribe_bh bh_Subscribe;
	Page_Subscribe_kw kw_Subscribe;
	WebDriverWait Common_Driver_Wait;

	@Test(groups = { "Task.Smoke" }, priority = 0, enabled = true)
	public void Check_SA_URL() {
		URL_Validate("Saudia Arabia", "/sa-ar");
	}

	@Parameters({ "KSALite", "KSABasic", "KSAPrem", "KSALitePrice", "KSABasicPrice", "KSAPremPrice", "KSACurrency" })
	@Test(groups = { "Task.Smoke" }, priority = 1, enabled = true)
	public void Check_Type_Price_Currency_SA(String Type_Name_Sa_Lite, String Type_Name_Sa_Basic,
			String Type_Name_Sa_Prime, String Price_Sa_Lite, String Price_Sa_Basic, String Price_Sa_Prem,
			String Currency_Sa) {
		subcribe = new Page_Subscribe(Test_Base_Common_Driver);

		/// Check Lite Sections
		Check_Type(Type_Name_Sa_Lite, subcribe.txt_Type_Lite, "Saudia Arabia");
		Check_Price(Type_Name_Sa_Lite, subcribe.txt_Price_Lite, "Saudia Arabia", Price_Sa_Lite);
		Check_Currency(Type_Name_Sa_Lite, subcribe.txt_Price_Lite, "Saudia Arabia", Currency_Sa);
		System.out.println("--------------- Price of SA Lite =" + subcribe.txt_Price_Lite.getText());

		/// Check Basic Sections
		Check_Type(Type_Name_Sa_Basic, subcribe.txt_Type_Basic, "Saudia Arabia");
		Check_Price(Type_Name_Sa_Basic, subcribe.txt_Price_Basic, "Saudia Arabia", Price_Sa_Basic);
		Check_Currency(Type_Name_Sa_Basic, subcribe.txt_Price_Basic, "Saudia Arabia", Currency_Sa);
		System.out.println("--------------- Price of SA Basic =" + subcribe.txt_Price_Basic.getText());

		/// Check Prem Sections
		Check_Type(Type_Name_Sa_Prime, subcribe.txt_Type_Prem, "Saudia Arabia");
		Check_Price(Type_Name_Sa_Prime, subcribe.txt_Price_Prem, "Saudia Arabia", Price_Sa_Prem);
		Check_Currency(Type_Name_Sa_Prime, subcribe.txt_Price_Prem, "Saudia Arabia", Currency_Sa);
		System.out.println("--------------- Price of SA Prem = " + subcribe.txt_Price_Prem.getText());

		subcribe.Choose_Country_BH();
	}

	@Parameters({ "BHLite", "BHBasic", "BHPrem", "BHLitePrice", "BHBasicPrice", "BHPremPrice", "BHCurrency" })
	@Test(groups = { "Task.Smoke" }, priority = 2, enabled = true)
	public void Check_Type_Price_Currency_BH(String Type_Name_BH_Lite, String Type_Name_BH_Basic,
			String Type_Name_BH_Prime, String Price_BH_Lite, String Price_BH_Basic, String Price_BH_Prem,
			String Currency_BH) {
		bh_Subscribe = new Page_Subscribe_bh(Test_Base_Common_Driver);

		/// Check correct URL
		URL_Validate("Bahrain", "/bh-ar");

		/// Check Lite Sections
		Check_Type(Type_Name_BH_Lite, bh_Subscribe.txt_Type_Lite, "Bahrain");
		Check_Price(Type_Name_BH_Lite, bh_Subscribe.txt_Price_Lite, "Bahrain", Price_BH_Lite);
		Check_Currency(Type_Name_BH_Lite, bh_Subscribe.txt_Price_Lite, "Bahrain", Currency_BH);
		System.out.println("--------------- Price of BH Lite =" + bh_Subscribe.txt_Price_Lite.getText());

		/// Check Basic Sections
		Check_Type(Type_Name_BH_Basic, bh_Subscribe.txt_Type_Basic, "Bahrain");
		Check_Price(Type_Name_BH_Basic, bh_Subscribe.txt_Price_Basic, "Bahrain", Price_BH_Basic);
		Check_Currency(Type_Name_BH_Basic, bh_Subscribe.txt_Price_Basic, "Bahrain", Currency_BH);
		System.out.println("--------------- Price of BH Basic =" + bh_Subscribe.txt_Price_Basic.getText());

		/// Check Prem Sections
		Check_Type(Type_Name_BH_Prime, bh_Subscribe.txt_Type_Prem, "Bahrain");
		Check_Price(Type_Name_BH_Prime, bh_Subscribe.txt_Price_Prem, "Bahrain", Price_BH_Prem);
		Check_Currency(Type_Name_BH_Prime, bh_Subscribe.txt_Price_Prem, "Bahrain", Currency_BH);
		System.out.println("--------------- Price of BH Prem =" + bh_Subscribe.txt_Price_Prem.getText());
		
		bh_Subscribe.Choose_Country_KW();
	}
	
	@Parameters({ "KWLite", "KWBasic", "KWPrem", "KWLitePrice", "KWBasicPrice", "KWPremPrice", "KWCurrency" })
	@Test(groups = { "Task.Smoke" }, priority = 2, enabled = true)
	public void Check_Type_Price_Currency_KW(String Type_Name_KW_Lite, String Type_Name_KW_Basic,
			String Type_Name_KW_Prime, String Price_KW_Lite, String Price_KW_Basic, String Price_KW_Prem,
			String Currency_KW) {
		kw_Subscribe = new Page_Subscribe_kw(Test_Base_Common_Driver);

		/// Check correct URL
		URL_Validate("Kwait", "/kw-ar");

		/// Check Lite Sections
		Check_Type(Type_Name_KW_Lite, kw_Subscribe.txt_Type_Lite, "Kwait");
		Check_Price(Type_Name_KW_Lite, kw_Subscribe.txt_Price_Lite, "Kwait", Price_KW_Lite);
		Check_Currency(Type_Name_KW_Lite, kw_Subscribe.txt_Price_Lite, "Kwait", Currency_KW);
		System.out.println("--------------- Price of KW Lite =" + kw_Subscribe.txt_Price_Lite.getText());

		/// Check Basic Sections
		Check_Type(Type_Name_KW_Basic, kw_Subscribe.txt_Type_Basic, "Kwait");
		Check_Price(Type_Name_KW_Basic, kw_Subscribe.txt_Price_Basic, "Kwait", Price_KW_Basic);
		Check_Currency(Type_Name_KW_Basic, kw_Subscribe.txt_Price_Basic, "Kwait", Currency_KW);
		System.out.println("--------------- Price of KW Basic =" + kw_Subscribe.txt_Price_Basic.getText());

		/// Check Prem Sections
		Check_Type(Type_Name_KW_Prime, kw_Subscribe.txt_Type_Prem, "Kwait");
		Check_Price(Type_Name_KW_Prime, kw_Subscribe.txt_Price_Prem, "Kwait", Price_KW_Prem);
		Check_Currency(Type_Name_KW_Prime, kw_Subscribe.txt_Price_Prem, "Kwait", Currency_KW);
		System.out.println("--------------- Price of KW Prem =" + kw_Subscribe.txt_Price_Prem.getText());
		
		//kw_Subscribe.Choose_Country_SA();
	}
	

	public void URL_Validate(String Country, String URL_Path) {
		try {
			System.out.println("[Info] Checking " + Country + " URL.");
			Assert.assertTrue(Test_Base_Common_Driver.getCurrentUrl().contains(URL_Path));
			System.out.println("[-- Test Passed] " + Country + " URL is correct.");

		} catch (AssertionError e) {
			System.out.println("[== Test Failed] " + Country + " URL is incorrect.");
			if (Country.contentEquals("Saudia Arabia"))
				Test_Base_Common_Driver.get("https://subscribe.stctv.com/sa-ar");
			if (Country.contentEquals("Bahrain"))
				Test_Base_Common_Driver.get("https://subscribe.stctv.com/bh-ar");
			if (Country.contentEquals("Kwait"))
				Test_Base_Common_Driver.get("https://subscribe.stctv.com/kw-ar");
			
			fail(e.getMessage());
		}
	}

	public void Check_Type(String Type_Name, WebElement element, String Country) {
		try {
			/// Checking Element exists?
			System.out.println("[Info] Checking " + Type_Name + " of " + Country + " element is exists?");
			Assert.assertTrue(element.isDisplayed());
			System.out.println("[-- Test Passed] Element " + Type_Name + " of " + Country + " is exists?");

			//// Checking value is correct?
			System.out.println("[Info] Checking value for " + Type_Name + " of " + Country + " as expected?");
			Assert.assertTrue(element.getText().contentEquals(Type_Name));
			System.out.println("[-- Test Passed] Value for " + Type_Name + " of " + Country + " is as expected");

		} catch (AssertionError e) {
			System.out.println("[== Test Failed] " + Type_Name + " of " + Country + ": Type value is not as expected");
			fail(e.getMessage());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("[== Test Failed] " + Type_Name + " of " + Country + ": elment is not exist on the page.");
			fail(e.getMessage());
		}
	}

	public void Check_Price(String Type_Name, WebElement element, String Country, String Price) {
		try {
			/// Checking Element exists?
			System.out.println("[Info] Checking price of " + Type_Name + " on " + Country + " element is exists?");
			Assert.assertTrue(element.isDisplayed());
			System.out.println("[-- Test Passed] Element of price for" + Type_Name + " on " + Country + " is exists");

			//// Checking value is correct?
			System.out.println("[Info] Checking price value of " + Type_Name + " on " + Country + " as expected?");
			Assert.assertTrue(element.getText().contains(Price));
			System.out.println("[-- Test Passed] price Value of " + Type_Name + " on " + Country + " is as expected");

		} catch (AssertionError e) {
			System.out.println(
					"[== Test Failed] Price value for " + Type_Name + " on " + Country + ": price value is not as expected");
			fail(e.getMessage());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out
					.println("[== Test Failed] Price of " + Type_Name + " of " + Country + ": elment is not exist on the page.");
			fail(e.getMessage());
		}
	}

	public void Check_Currency(String Type_Name, WebElement element, String Country, String Currency) {
		try {
			/// Checking Element exists?
			System.out.println("[Info] Checking currency of " + Type_Name + " on " + Country + " element is exists?");
			Assert.assertTrue(element.isDisplayed());
			System.out.println("[-- Test Passed] Element of currency for" + Type_Name + " on " + Country + " is exists");

			//// Checking value is correct?
			System.out.println("[Info] Checking currency value of " + Type_Name + " on " + Country + " as expected?");
			Assert.assertTrue(element.getText().contains(Currency));
			System.out.println("[-- Test Passed] currency Value of " + Type_Name + " on " + Country + " is as expected");

		} catch (AssertionError e) {
			System.out.println(
					"[== Test Failed] curreny value for " + Type_Name + " on " + Country + ": currency value is not as expected");
			fail(e.getMessage());
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out
					.println("[== Test Failed] Price of " + Type_Name + " of " + Country + ": elment is not exist on the page.");
			fail(e.getMessage());
		}
	}

	@DataProvider
	public String[][] Request_Data_From_Excel_Sheet() throws Exception {
		return null;
	}

}
