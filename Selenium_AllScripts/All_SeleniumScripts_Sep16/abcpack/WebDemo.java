package abcpack;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDemo {
	WebDriver d;
	@Before
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		//Maximize window
		d.manage().window().maximize();
	}
	@Test
	public void testWebDemo() throws Exception
	{
		//Load web page
		d.get("https://www.facebook.com/");
		//Print page title
		//System.out.println("Page title is:"+d.getTitle());
		//Verify page title
		assertEquals("Facebook - Log In or Sign Up",d.getTitle());
		//Enter user name
		d.findElement(By.id("email")).sendKeys("Selenium");
		//Enter password
		d.findElement(By.id("pass")).sendKeys("Selenium");
		//Click on Login button
		d.findElement(By.id("u_0_m")).click();
		//Pause 4sec
		Thread.sleep(4000);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
