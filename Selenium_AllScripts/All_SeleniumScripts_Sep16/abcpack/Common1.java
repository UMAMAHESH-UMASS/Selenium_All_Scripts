package abcpack;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common1 {
	WebDriver d;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws Exception
	{
		//Launch browser
		if(browser.equalsIgnoreCase("FF"))
		{
			d=new FirefoxDriver();
			//d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.firefox());
		}
		else if(browser.equalsIgnoreCase("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Driver Server\\chromedriver.exe");
			d =new ChromeDriver();
			//d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.chrome());
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Driver Server\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
			//d = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),DesiredCapabilities.internetExplorer());
		}
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
