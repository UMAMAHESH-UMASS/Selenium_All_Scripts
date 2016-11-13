package abcpack;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DataImport_POI {
WebDriver d;
	
	@Test
	public void testDataImport() throws Exception
	{
		//Load web page
		d.get("https://www.google.co.in");
		assertEquals("Google",d.getTitle());
		FileInputStream fis=new FileInputStream("D:\\Selenium_Scripts_Aug16\\Test Data\\Google2.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s=wb.getSheetAt(0);
		for(int i=0;i<s.getLastRowNum()+1;i++)
		{
			d.findElement(By.id("lst-ib")).clear();
			d.findElement(By.id("lst-ib")).sendKeys(s.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(2000);
		}
		
	}
	@BeforeMethod
	public void setUp()
	{
		//Launch browser
		d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown()
	{
		//Close browser
		d.quit();
	}

}
