import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class DragAround {
	WebDriver driver;
	String expectedWebpageUrl;
	
	public DragAround(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void dragAnddrop()
	{
		 Actions actions = new Actions(driver);

	        WebElement element = driver.findElement(By.id("dragbox")); 

	    	WebElement target = driver.findElement(By.id("dropbox"));

	    	(new Actions(driver)).dragAndDrop(element, target).perform();
	    	driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	    	expectedWebpageUrl = "http://10.0.1.86/tatoc/basic/windows"; //url of next page
	        Assert.assertEquals(expectedWebpageUrl, driver.getCurrentUrl(), "Not as expected webpage");
	}

	 
	
}
