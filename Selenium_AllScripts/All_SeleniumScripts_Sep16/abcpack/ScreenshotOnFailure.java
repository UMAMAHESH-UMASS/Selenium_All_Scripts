package abcpack;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ScreenshotOnFailure {
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		assertEquals("Pass",getScreenshot());		
		Thread.sleep(4000);
		
	}
	public String getScreenshot() throws Exception
	{
		try
		{
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
			return "Pass";
		}
		catch(Exception e)
		{
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File("D:\\Selenium_Scripts_Aug16\\Results\\"+dateFormat.format(dt)+".png"));
	        return "Fail";
		}
	}
	@Before
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
