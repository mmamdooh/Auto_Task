package pagesBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page
{
	protected WebDriver PageBase_WebDriver;
	JavascriptExecutor JSExe;


	public Base_Page(WebDriver Constructor_WebDriver)
	{
		PageFactory.initElements(Constructor_WebDriver, this);
		this.PageBase_WebDriver = Constructor_WebDriver;
	}
	
	public void Page_Scrol_Down(int Scrol_Value)
	{
		JSExe = (JavascriptExecutor)PageBase_WebDriver;
		JSExe.executeScript("window.scrollBy(0, " +  Scrol_Value + ")");
	}

}
