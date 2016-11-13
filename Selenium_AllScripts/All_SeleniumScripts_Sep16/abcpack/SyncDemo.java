package abcpack;

import static org.testng.Assert.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class SyncDemo extends Common1
{
	
	@Test
	public void testSync() throws Exception
	{
		//Load web page
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		//Type text
		d.findElement(By.id("lst-ib")).sendKeys("Selenium");
		//Click on search button
		d.findElement(By.name("btnG")).click();
		//Explicitwait
		WebDriverWait wait=new WebDriverWait(d,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Downloads - Selenium")));
		
		//Click on Downloads - Selenium
		d.findElement(By.linkText("Downloads - Selenium")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Projects")));
		//Click on Projects
		d.findElement(By.linkText("Projects")).click();
		Thread.sleep(4000);
	}
	

}
