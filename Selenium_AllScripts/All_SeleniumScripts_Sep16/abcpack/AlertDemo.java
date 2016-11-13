package abcpack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AlertDemo {
	WebDriver d;
	@Test
	public void testAlert() throws Exception
	{
		//Load web page
		d.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		assertEquals("IRCTC Next Generation eTicketing System",d.getTitle());
		//Click on Login button
		d.findElement(By.id("loginbutton")).click();
		//Switch driver focus to alert
		Alert al=d.switchTo().alert();
		//Verify alert text
		assertEquals("Enter User ID",al.getText());
		//ok
		al.accept();
		//Enter user name
		d.findElement(By.id("usernameId")).sendKeys("Selenium");
		//Click on Login button
		d.findElement(By.id("loginbutton")).click();
		//ok
		al.accept();
		//Enter password
		d.findElement(By.name("j_password")).sendKeys("Selenium");
		//Click on Login button
		d.findElement(By.id("loginbutton")).click();
		//ok
		al.accept();
		Thread.sleep(4000);
		
	}
	@Before
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\Driver Server\\chromedriver.exe");
		//d =new ChromeDriver();
		System.setProperty("webdriver.ie.driver", "D:\\Driver Server\\IEDriverServer.exe");
		//d=new InternetExplorerDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
