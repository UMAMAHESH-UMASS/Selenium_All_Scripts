package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		//Load web page
		d.get("http://49.206.196.246:8080/Cyclos/do/login");
		assertEquals("Indianbank-Hyderabad",d.getTitle());
		//Enter user name
		d.findElement(By.id("cyclosUsername")).clear();
		d.findElement(By.id("cyclosUsername")).sendKeys("qttesters");
		String uname=d.findElement(By.id("cyclosUsername")).getAttribute("value");
		//Enter password
		d.findElement(By.id("cyclosPassword")).clear();
		d.findElement(By.id("cyclosPassword")).sendKeys("qttesters");
		String password=d.findElement(By.id("cyclosPassword")).getAttribute("value");
		//Click on submit
		d.findElement(By.xpath("//input[@value='Submit']")).click();
		//Blank user name & blank password
		if(uname.equals("") && password.equals(""))
		{
			Alert al=d.switchTo().alert();
			assertEquals("Login name is required\nPassword is required\n",al.getText());
			al.accept();
		}
		//Blank user name & Valid/Invalid password
		else if(uname.equals(""))
		{
			Alert al=d.switchTo().alert();
			assertEquals("Login name is required\n",al.getText());
			al.accept();
		}
		//Blank password & valid/In valid user name
		else if(password.equals(""))
		{
			Alert al=d.switchTo().alert();
			assertEquals("Password is required\n",al.getText());
			al.accept();
		}
		//Valid user name & valid password
		else if(isElementPresent(d,By.xpath("//span[text()='Logout']")))
		{
			d.findElement(By.xpath("//span[text()='Logout']")).click();
			//Switch driver focus to alert
			Alert al=d.switchTo().alert();
			al.accept();
		}
		//Invalid user name & invalid password
		else if(isElementPresent(d,By.id("btn")))
		{
			d.findElement(By.id("btn")).click();
		}
		
		
		Thread.sleep(3000);
	}
	private boolean isElementPresent(WebDriver d,By by) {
		d.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	    try {
	      d.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
