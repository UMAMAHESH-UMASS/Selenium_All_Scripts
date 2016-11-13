package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverDemo {
	WebDriver d;
	@Test
	public void testMouseOver() throws Exception
	{
		//Load web page
		d.get("https://www.policybazaar.com/");
		assertEquals("Compare Insurance Quotes Online: Life | Car | Health | Travel",d.getTitle());
		Actions a=new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//div[@id='navbar']/ul[2]/li/a"))).perform();
		//a.moveToElement(d.findElement(By.xpath("//div[@id='navbar']/ul[2]/li/a"))).click(d.findElement(By.linkText("Child Plans"))).build().perform();
		d.findElement(By.linkText("Child Plans")).click();
		Thread.sleep(4000);
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
