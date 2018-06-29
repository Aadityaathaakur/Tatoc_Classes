import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import UtilPackage.LocatorsCall;

public class LauchPopupMenu {
	static WebDriver driver=BrowserDetails.driver;
	
	static LocatorsCall lc= new LocatorsCall(driver);
	
	
	public static String  launchwithoutpopupClick()
	{
		 //driver.findElement(By.xpath("/html/body/div/div[2]/a[2]")).click();
		// return driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
		lc.getWebElementsTag("popupProceed").click();
		
	return lc.getWebElementsTag("afterPopupTitle").getText();
		  
		   
	}
	
	public static String  launchPopUp() {
		driver.get(" http://10.0.1.86/tatoc/basic/windows");
		
		String mainWindow = driver.getWindowHandle();
		//driver.findElement(By.linkText("Launch Popup Window")).click();
		lc.getWebElementsTag("launchPopup").click();
		
		String SecWindow = null;
		 
	    Set<String> handles = driver.getWindowHandles();
	    System.out.println(handles);
	    
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	    	
	    	SecWindow = iterator.next();
	    }
	 // switch to popup window
	      driver.switchTo().window(SecWindow); 
	   // driver.findElement(By.id("name")).sendKeys("Aditya");
	    //driver.findElement(By.id("submit")).click();
	    lc.getWebElementsTag("popUpText").sendKeys("Aditya");
	    lc.getWebElementsTag("txtSubmit").click();
	    driver.switchTo().window(mainWindow);
	    //driver.findElement(By.xpath("/html/body/div/div[2]/a[2]")).click();
	    lc.getWebElementsTag("popupProceed").click();
	    return driver.getTitle();

    }
}
