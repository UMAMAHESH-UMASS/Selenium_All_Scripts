package abcpack;
import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class D {
	
	WebDriver d;
	@Before
	public  void setup(){
		//launch browser
			d= new FirefoxDriver();
		//open site
			//d.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
			
	}
//test case
	@Test
	public  void testFrames() throws Exception{
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.get("http://seleniumhq.org");
		//click Download tab
		d.findElement(By.linkText("Download")).click();
		//click Java Doc
	//d.findElement(By.xpath(".//*[@id='mainContent']/table[1]/tbody/tr[1]/td[6]/a")).click();
		//click the link Java Doc
      assertTrue(d.findElement(By.linkText("Javadoc")).isDisplayed());
      //System.out.println("Element is displayed or not "+d.findElement(By.linkText("Javadoc")).isDisplayed());
		Thread.sleep(2000);
      d.findElement(By.linkText("Javadoc")).click();
		Thread.sleep(4000);
	}
	@After
	public void tearDown(){
		d.quit();
		
	}
	
	
	
}
