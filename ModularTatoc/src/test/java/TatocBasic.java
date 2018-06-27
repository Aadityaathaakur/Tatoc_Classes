import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TatocBasic {
	String mainWindow;
	String expectedWebpageUrl;
	WebElement element;
	WebDriver driver;
	
	public TatocBasic(WebDriver driver)
	{
		this.driver=driver;
	 	}

	
	 
	  public void basicCource() {
			 Assert.assertEquals(driver.findElement(By.linkText("Basic Course")).isDisplayed(), true);
					this.driver.findElement(By.linkText("Basic Course")).click();
	  }
	 
}
