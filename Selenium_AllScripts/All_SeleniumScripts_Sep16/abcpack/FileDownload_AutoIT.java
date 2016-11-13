package abcpack;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class FileDownload_AutoIT {
	WebDriver d;
	@BeforeMethod
	public void init()
	{
		d = new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
	}
	@AfterMethod
	public void stop()
	{
		//d.quit();
	}
	@Test
	public void testDownload() throws InterruptedException, IOException
	{
		
		d.get("http://seleniumhq.org/download/");
		d.findElement(By.linkText("3.0.0-beta4")).click();
		Thread.sleep(1000);
		
		new ProcessBuilder("F:\\AutoIT Scripts\\FDownload.exe").start(); 
		Thread.sleep(8000);

		
	}

}