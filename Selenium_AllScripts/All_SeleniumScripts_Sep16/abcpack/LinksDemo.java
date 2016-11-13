package abcpack;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class LinksDemo extends Common1
{
	
	@Test
	public void testLinks() throws Exception
	{
		//Load web page
		d.get("http://docs.seleniumhq.org/");
		assertEquals("Selenium - Web Browser Automation",d.getTitle());
		List<WebElement> l=d.findElements(By.xpath("//li[starts-with(@id,'menu')]"));
		System.out.println("No of links:"+l.size());
		System.out.println("*********** Links are ************");
		String link[]=new String[l.size()];
		int i=0;
		for(WebElement e:l)
		{
			System.out.println(e.getText());
			link[i]=e.getText();
			i++;
		}
		for(String t:link)
		{
			d.findElement(By.linkText(t)).click();
			if(d.getTitle().contains("404"))
			{
				System.out.println("Link:"+t+": is not working");
			}
			else
			{
				System.out.println("Link:"+t+": is working fine");
			}
		}
		Thread.sleep(2000);
	}


}
