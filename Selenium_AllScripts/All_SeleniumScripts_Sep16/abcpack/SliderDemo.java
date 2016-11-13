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

public class SliderDemo {
	WebDriver d;
	@Test
	public void testDragNDrop() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/slider/");
		assertEquals("Slider | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		Actions a=new Actions(d);
		a.dragAndDropBy(d.findElement(By.xpath("//div[@id='slider']/span")), 250, 0).perform();
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
