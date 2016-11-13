package abcpack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class AjaxDemo {
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		//Load web page
		d.get("http://www.veethi.com/places/india_banks-ifsc-micr-codes.html");
		assertEquals("Bank IFSC Codes, MICR Codes: Find IFSC, MICR Codes for Major Banks in India",d.getTitle());
		//Select bank
		Select bank=new Select(d.findElement(By.id("selBank")));
		bank.selectByIndex(4);
		//Select state
		Select state=new Select(d.findElement(By.id("selState")));
		state.selectByVisibleText("Andhra Pradesh");
		//Select city
		Select city=new Select(d.findElement(By.id("selCity")));
		city.selectByVisibleText("Hyderabad");
		//Select branch
		Select branch=new Select(d.findElement(By.id("selBranch")));
		branch.selectByVisibleText("Gachibowli");
		Thread.sleep(4000);
		
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
