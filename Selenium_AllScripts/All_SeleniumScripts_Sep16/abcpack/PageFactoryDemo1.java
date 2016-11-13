package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryDemo1 extends Common1
{
	
	@Test
	public void testLogin() throws Exception
	{
		//Load web page
		d.get("http://49.206.196.246:8080/Cyclos/do/login");
		assertEquals("Indianbank-Hyderabad",d.getTitle());
		OR1 page=new OR1(d);
		
		page.fillLogin("qttesters", "qttesters");
		page.btnlogout.click();
		page.clickOk();
		
		/*//Enter user name
		page.txtuname.sendKeys("qttesters");
		//Enter password
		page.txtpwd.sendKeys("qttesters");
		//Click on submit
		page.btnsubmit.click();
		//Click on logout
		page.btnlogout.click();
		//Switch driver focus to alert
		Alert al=d.switchTo().alert();
		//ok
		al.accept();*/
		Thread.sleep(4000);
		
	}
	

}
