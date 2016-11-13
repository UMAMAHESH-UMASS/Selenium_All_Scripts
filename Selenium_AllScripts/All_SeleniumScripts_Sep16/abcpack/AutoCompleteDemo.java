package abcpack;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutoCompleteDemo extends Common1
{
	
	@Test
	public void testAutocomplete() throws Exception
	{
		//Load web page
		d.get("http://jqueryui.com/autocomplete/");
		assertEquals("Autocomplete | jQuery UI",d.getTitle());
		//Switch driver focus to frame
		d.switchTo().frame(0);
		//Type text
		d.findElement(By.id("tags")).sendKeys("a");
		List<WebElement> s=d.findElements(By.className("ui-menu-item"));
		System.out.println("No of suggestions is:"+s.size());
		System.out.println("************** Suggestion are ******************");
		for(WebElement e:s)
		{
			System.out.println(e.getText());
		}
		if(s.size()>=3)
		{
			for(int i=0;i<3;i++)
			{
				d.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
			}
			d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
			
		}
		Thread.sleep(4000);
	}
	

}
