package abcpack;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationDemo {
	WebDriver d;
	@Test
	public void testConfirmation() throws Exception
	{
		//Load web page
		d.get("http://output.jsbin.com/enifaf");
		d.findElement(By.cssSelector("button")).click();
		//Switch driver focus to confirmation
		Alert al=d.switchTo().alert();
		assertEquals("Press a button!",al.getText());
		//Cancel
		al.dismiss();
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
