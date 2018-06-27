import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LauchPopupMenu {
	WebDriver driver;
	String expectedWebpageUrl;
	String mainWindow;
	public LauchPopupMenu(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void launchwithoutpopupClick()
	{
		 driver.findElement(By.xpath("/html/body/div/div[2]/a[2]")).click();
		 String error=this.driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
		    System.out.println("error="+error);
		    
		    Assert.assertEquals("The page you are looking for does not exist", error, "Not as expected webpage");

	}
	public void launchPopUp() {
		mainWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Launch Popup Window")).click();
		
		
		String SecWindow = null;
		 // getting other (ALL) windows
	    Set<String> handles = driver.getWindowHandles();
	    System.out.println(handles);
	    
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	    	
	    	SecWindow = iterator.next();
	    }
	 // switch to popup window
	    driver.switchTo().window(SecWindow); 
	    driver.findElement(By.id("name")).sendKeys("Aditya");
	    driver.findElement(By.id("submit")).click();
	    
	    driver.switchTo().window(mainWindow);
	    driver.findElement(By.xpath("/html/body/div/div[2]/a[2]")).click();
	  
	    
	    expectedWebpageUrl = "http://10.0.1.86/tatoc/basic/cookie"; //url of next page
        Assert.assertEquals(expectedWebpageUrl, driver.getCurrentUrl(), "Not as expected webpage");

    }
}
