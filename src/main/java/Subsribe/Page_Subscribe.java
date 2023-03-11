package Subsribe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pagesBase.Base_Page;

public class Page_Subscribe extends Base_Page
{

	WebDriver Subsribe_WebDriver;
	WebDriverWait wait;
	
	@FindBy(how = How.ID, using = "country-btn")
	public WebElement btn_Region;
	
	@FindBy(how = How.ID, using = "country-selct")
	public WebElement div_Countries;
	
	@FindBy(how = How.ID, using = "bh")
	public WebElement btn_BH;
	
	@FindBy(how = How.ID, using = "kw")
	public WebElement btn_KW;
	
	@FindBy(how = How.XPATH, using = "//strong[@id = 'name-لايت']")
	public WebElement txt_Type_Lite;
	
	@FindBy(how = How.XPATH, using = "//strong[@id = 'name-الأساسية']")
	public WebElement txt_Type_Basic;
	
	@FindBy(how = How.XPATH, using = "//strong[@id = 'name-بريميوم']")
	public WebElement txt_Type_Prem;
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'currency-لايت']")
	public WebElement txt_Price_Lite;
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'currency-الأساسية']")
	public WebElement txt_Price_Basic;
	
	@FindBy(how = How.XPATH, using = "//div[@id = 'currency-بريميوم']")
	public WebElement txt_Price_Prem;
		
	
	public Page_Subscribe(WebDriver Constructor_WebDriver)
	{
		super(Constructor_WebDriver);
		this.Subsribe_WebDriver = Constructor_WebDriver;
		PageFactory.initElements(Constructor_WebDriver, this);
		wait = new WebDriverWait(Subsribe_WebDriver, 10);
	}
	
	public void Choose_Country_BH() {
		btn_Region.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_BH));
		
		btn_BH.click();
		wait.until(ExpectedConditions.visibilityOf(txt_Type_Lite));

	}

}
