package abcpack;
import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sample {
  private WebDriver d;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    d = new FirefoxDriver();
    baseUrl = "https://www.google.co.in/";
    d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    d.get(baseUrl + "/?gfe_rd=cr&ei=AreeV4bWKLTv8wfihZZg");
    assertEquals("Google", d.getTitle());
    d.findElement(By.id("lst-ib")).clear();
    //ID
    //d.findElement(By.id("lst-ib")).sendKeys("selenium");
    //Name
    //d.findElement(By.name("q")).sendKeys("Appium");
    //Class
    //d.findElement(By.className("gsfi")).sendKeys("QTP");
    //Link Text
    //d.findElement(By.linkText("Sign in")).click();
    //Partial link text
    //d.findElement(By.partialLinkText("Sign")).click();
    //XPath
    //d.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
    //Tag Name
  /*  List<WebElement> l=d.findElements(By.tagName("a"));
    System.out.println("No of links:"+l.size());*/
    //d.findElement(By.name("btnG")).click();
    //CSS
    d.findElement(By.cssSelector("a.gb_P")).click();
    Thread.sleep(4000);
  }

  @After
  public void tearDown() throws Exception {
    d.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      d.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      d.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = d.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}


