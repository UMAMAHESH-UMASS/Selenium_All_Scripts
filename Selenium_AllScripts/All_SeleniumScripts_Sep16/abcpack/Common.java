package abcpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
	WebDriver d;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		//Launch browser
		if(browser.equals("FF"))
		{
			d=new FirefoxDriver();
		}
		else if(browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Driver Server\\chromedriver.exe");
			d=new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Driver Server\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
