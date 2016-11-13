package abcpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MultiFrameDemo {
	WebDriver d;
	@Test
	public void testMultiFrame() throws Exception
	{
		//Load web page
		d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		List<WebElement> f=d.findElements(By.tagName("frame"));
		//System.out.println("No of frames:"+f.size());
		//Switch driver focus to 1st frame
		d.switchTo().frame(0);
		d.findElement(By.linkText("com.thoughtworks.selenium")).click();
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Switch driver focus to 2nd frame
		d.switchTo().frame(1);
		d.findElement(By.linkText("Selenium")).click();
		//Switch driver focus outside frame
		d.switchTo().defaultContent();
		//Switch driver focus to 3rd frame
		d.switchTo().frame(2);
		d.findElement(By.linkText("DefaultSelenium")).click();
		Thread.sleep(4000);
	}
	@BeforeMethod
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
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}


}
