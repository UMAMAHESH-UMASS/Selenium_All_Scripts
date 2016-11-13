package abcpack;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementsDemo {
	WebDriver d;
	@Before
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
	}
	@Test
	public void testWebElements() throws Exception
	{
		//Load web page
		d.get("http://book.theautomatedtester.co.uk/");
		//Type text
		d.findElement(By.id("q")).sendKeys("Selenium");
		//Click on Chapter1
		d.findElement(By.linkText("Chapter1")).click();
		//Radio button
		WebElement radio=d.findElement(By.id("radiobutton"));
		if(radio.isSelected())
		{
			System.out.println("Radio button is already selected");
		}
		else
		{
			radio.click();
		}
		//Check box
		WebElement chkbox=d.findElement(By.name("selected(1234)"));
		if(chkbox.isSelected())
		{
			System.out.println("Check box is already selected");
		}
		else
		{
			chkbox.click();
		}
		//DD
		Select dd=new Select(d.findElement(By.id("selecttype")));
		dd.selectByIndex(2);
		//Text area
		d.findElement(By.id("html5div")).clear();
		d.findElement(By.id("html5div")).sendKeys("Selenium\nAppium");
		//Pause 4sec
		Thread.sleep(4000);
	}
	@After
	public void tearDown()
	{
		//Close browser
		d.quit();
	}
}
