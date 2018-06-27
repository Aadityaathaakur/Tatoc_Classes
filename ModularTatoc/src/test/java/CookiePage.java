import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiePage {
	WebDriver driver;
	String expectedWebpageUrl;
	String mainWindow;
	public CookiePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
    public void cookieAdd() {
	
driver.findElement(By.cssSelector("a")).click();
    
    //String value = driver.findElement(By.id("token")).getText().split("Token: ")[1];    
    
    
    String Tokenvalue = driver.findElement(By.id("token")).getText();
     Tokenvalue = (Tokenvalue.substring(7));
    
    System.out.println(Tokenvalue);
    
    //adding cookie
    Cookie ck = new Cookie("Token", Tokenvalue);
    driver.manage().addCookie(ck);
    
	
    
    //driver.manage().addCookie( new Cookie("Token", Tokenvalue, "/")); 
    driver.findElements(By.cssSelector("a")).get(1).click(); 
    expectedWebpageUrl = "http://10.0.1.86/tatoc/end"; //url of next page
    Assert.assertEquals(expectedWebpageUrl, driver.getCurrentUrl(), "Not as expected webpage");
	}
}
