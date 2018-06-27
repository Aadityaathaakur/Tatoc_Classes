import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RedGreenBox {
	WebElement element;
	WebDriver driver;
	String expectedWebpageUrl;
	public RedGreenBox(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void RedBox() {
		
	    Assert.assertEquals(this.driver.findElement(By.className("redbox")).isDisplayed(), true);
	    
	    this.driver.findElement(By.className("redbox")).click();
	    String error=this.driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
	    System.out.println("errorrrrr="+error);
	    
	    Assert.assertEquals("The page you are looking for does not exist", error, "Not as expected webpage");

	}
public void greenBox() {
	driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
    Assert.assertEquals(this.driver.findElement(By.className("greenbox")).isDisplayed(), true);
    
    this.driver.findElement(By.className("greenbox")).click();
     
    expectedWebpageUrl = "http://10.0.1.86/tatoc/basic/frame/dungeon";

    Assert.assertEquals(expectedWebpageUrl, driver.getCurrentUrl(), "Not as expected webpage");

}

}
