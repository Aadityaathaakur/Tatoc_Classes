import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import UtilPackage.LocatorsCall;



public class DragAround {
	static WebDriver driver=BrowserDetails.driver;
	static LocatorsCall lc= new LocatorsCall(driver);

	
	public static String dragAnddrop()
	{System.out.println("dr "+driver);
		    Actions actions = new Actions(driver);

	       // WebElement element = driver.findElement(By.id("dragbox")); 
		    WebElement element = lc.getWebElementsTag("dragBoxId");
	    	//WebElement target = driver.findElement(By.id("dropbox"));
	    	WebElement target = lc.getWebElementsTag("dropboxId");

	    	(new Actions(driver)).dragAndDrop(element, target).perform();
	    	
	    	//driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	    	lc.getWebElementsTag("DragClick").click();
	    	return driver.getTitle();
			
	}

	 
	
}
