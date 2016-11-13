package abcpack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR1 {
	WebDriver d;
	OR1(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this);
	}
	@FindBy(id="cyclosUsername") WebElement txtuname;
	@FindBy(id="cyclosPassword") WebElement txtpwd;
	@FindBy(xpath="//input[@value='Submit']") WebElement btnsubmit;
	@FindBy(xpath="//span[text()='Logout']") WebElement btnlogout;
	
	public void fillLogin(String uname,String pwd)
	{
		txtuname.clear();
		txtuname.sendKeys(uname);
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
		btnsubmit.click();
	}
	//Ok
	public void clickOk()
	{
		Alert al=d.switchTo().alert();
		al.accept();
	}
	//Cancel
	public void clickCancel()
	{
		Alert al=d.switchTo().alert();
		al.dismiss();
	}

}
